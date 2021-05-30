package controller.commands;

import control.PostFacade;
import control.UserFacade;
import control.UserPostSubjectPublicationrelationFacade;
import entities.Post;
import entities.Subject;
import entities.User;
import entities.UserPostSubjectPublicationrelation;
import entities.UserPostSubjectPublicationrelationPK;
import java.sql.Timestamp;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Publish extends FrontCommand {

    private PostFacade postFacade;
    private UserFacade userFacade;
    private UserPostSubjectPublicationrelationFacade userPostSubjectPublicationrelationFacade;

    @Override
    public void process() {
        try {        
            postFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/PostFacade!control.PostFacade");
            userFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/UserFacade!control.UserFacade");

            userPostSubjectPublicationrelationFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/UserPostSubjectPublicationrelationFacade!control.UserPostSubjectPublicationrelationFacade");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        User user = (User) request.getSession().getAttribute("user"); 
        Subject subject = (Subject) request.getSession().getAttribute("subjectChoosen");
        Post post = new Post((String) request.getParameter("title"), new Timestamp(System.currentTimeMillis()), (String) request.getParameter("content"), !request.getParameter("pathImage").equals("null") ? request.getParameter("pathImage"): null , subject , user);
        user.addMyPostsCollection(post);      
        postFacade.create(post);
        UserPostSubjectPublicationrelationPK userPostSubjectPublicationrelationPK = new UserPostSubjectPublicationrelationPK(user.getId(), post.getId(), subject.getId());
        UserPostSubjectPublicationrelation userPostSubjectPublicationrelation = new UserPostSubjectPublicationrelation(post, subject, user, userPostSubjectPublicationrelationPK);
        user.addUserPostSubjectPublicationrelationCollection(userPostSubjectPublicationrelation);
        post.addUserPostSubjectPublicationrelationCollection(userPostSubjectPublicationrelation);
        subject.addUserPostSubjectPublicationrelationCollection(userPostSubjectPublicationrelation); 
        userPostSubjectPublicationrelationFacade.edit(userPostSubjectPublicationrelation);
        request.setAttribute("postsMYUser", postFacade.findByUser((User) request.getSession().getAttribute("user")));
        forward("/ShowMyPosts.jsp");
    }

}
