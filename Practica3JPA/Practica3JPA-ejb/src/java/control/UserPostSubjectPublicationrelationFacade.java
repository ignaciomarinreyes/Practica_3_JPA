/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entities.Post;
import entities.User;
import entities.UserPostSubjectPublicationrelation;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ignacio
 */
@Stateless
public class UserPostSubjectPublicationrelationFacade extends AbstractFacade<UserPostSubjectPublicationrelation> {

    @PersistenceContext(unitName = "Practica3JPA-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserPostSubjectPublicationrelationFacade() {
        super(UserPostSubjectPublicationrelation.class);
    }

    public List findPostsofFollowedSubjectsByUser(User user) {
        List<UserPostSubjectPublicationrelation> userPostSubjectRList = em.createQuery("select DISTINCT usp FROM UserPostSubjectPublicationrelation usp JOIN usp.user u WHERE usp.subject IN (u.subjectCollection)").getResultList();
        List<Post> posts = getListPosts(userPostSubjectRList);
        return posts;
    }

    private List<Post> getListPosts(List<UserPostSubjectPublicationrelation> userPostSubjectRList) {
        List<Post> postsFollowed = new ArrayList<Post>();
        for (UserPostSubjectPublicationrelation UserPostSubjectR : userPostSubjectRList) {
            postsFollowed.add(UserPostSubjectR.getPost());
        }
        return postsFollowed;
    }

}
