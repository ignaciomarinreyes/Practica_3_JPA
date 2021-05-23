/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entities.Degree;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ignacio
 */
@Stateless
public class DegreeFacade extends AbstractFacade<Degree> {

    @PersistenceContext(unitName = "Practica3JPA-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DegreeFacade() {
        super(Degree.class);
    }

    public List<Degree> findByUniversityName(String searchedValue) {
        return em.createQuery("select d from Degree d where d.name like :searchedValue OR d.university.name like :searchedValue ORDER BY d.university.name ASC").setParameter("searchedValue", "%" + searchedValue + "%").getResultList();
    }
    
}
