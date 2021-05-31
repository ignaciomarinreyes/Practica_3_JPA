/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entities.Post;
import entities.Subject;
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

    public List<Post> findPostsofFollowedSubjectsByUser(User user) {
        List<UserPostSubjectPublicationrelation> allPostUserSubject = this.findAll();
        List<Subject> followedSubject = (List<Subject>) user.getFollowedSubjects();
        List<Post> postsofFollowedSubjectByuser = new ArrayList<Post>();
        for(UserPostSubjectPublicationrelation userPostSubjectPublicationrelation:allPostUserSubject){
            for(Subject subjectFollowed:followedSubject){
                if(userPostSubjectPublicationrelation.getSubject().getId().intValue() == subjectFollowed.getId().intValue()){
                    postsofFollowedSubjectByuser.add(userPostSubjectPublicationrelation.getPost());
                }
            }
        }
        return postsofFollowedSubjectByuser;
    }

}
