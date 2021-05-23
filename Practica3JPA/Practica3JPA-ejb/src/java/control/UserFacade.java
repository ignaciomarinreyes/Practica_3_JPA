/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entities.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

/**
 *
 * @author ignacio
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {

    @PersistenceContext(unitName = "Practica3JPA-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }

    public List<User> findByNicknameAndPassword(String nickname, String password) {
        return em.createQuery("select u from User u where u.nickname = :nickname AND u.password = :password").setParameter("nickname", nickname).setParameter("password", password).getResultList();
    }

    public List<User> findByNameOrNicknameOrPasswordOrSurnameLikeOrderByIdDescd(String searchedValue) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> q = cb.createQuery(User.class);
        Root<User> c = q.from(User.class);
        ParameterExpression<String> p = cb.parameter(String.class);
        q.select(c).where(
                cb.or(
                    cb.like(c.get("name"), p),
                    cb.like(c.get("nickname"), p),
                    cb.like(c.get("password"), p),
                    cb.like(c.get("surname"), p)
                )
        ).orderBy(cb.desc(c.get("id")));
        TypedQuery<User> query = em.createQuery(q);
        query.setParameter(p, "%" + searchedValue + "%");
        return query.getResultList();
    }
    
}
