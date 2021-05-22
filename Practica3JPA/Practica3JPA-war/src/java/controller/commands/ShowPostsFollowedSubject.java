package controller.commands;

import entities.User;
import control.PostFacade;
import control.UserPostSubjectRFacade;
import entities.Post;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ShowPostsFollowedSubject extends FrontCommand {

    private UserPostSubjectRFacade userPostSubjectRFacade;
    
    @Override
    public void process() {
        try {
            userPostSubjectRFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/UserPostSubjectRFacade!control.UserPostSubjectRFacade");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        List<Post> postFollowedSubjectByUser = userPostSubjectRFacade.findPostsofFollowedSubjectsByUser((User) request.getSession().getAttribute("user"));
        request.setAttribute("PostsFollowedSubjectsByUser", postFollowedSubjectByUser);
        forward("/MainFrame.jsp");
    }

}
