package controller.commands;

import entities.User;
import control.UserPostSubjectPublicationrelationFacade;
import entities.Post;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ShowPostsFollowedSubject extends FrontCommand {

    private UserPostSubjectPublicationrelationFacade userPostSubjectPublicationrelationFacade;
    
    @Override
    public void process() {
        try {
            userPostSubjectPublicationrelationFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/UserPostSubjectPublicationrelationFacade!control.UserPostSubjectPublicationrelationFacade");
        } catch (NamingException ex) {
            ex.printStackTrace();
        } 
        List<Post> postFollowedSubjectByUser = userPostSubjectPublicationrelationFacade.findPostsofFollowedSubjectsByUser((User) request.getSession().getAttribute("user"));
        request.setAttribute("PostsFollowedSubjectsByUser", postFollowedSubjectByUser);
        forward("/MainFrame.jsp");
    }

}
