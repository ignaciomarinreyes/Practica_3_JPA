package controller.commands;

import entities.User;
import control.UserFacade;
import control.UserPostSubjectPublicationrelationFacade;
import entities.Post;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Login extends FrontCommand {

    private UserFacade userFacade;
    private UserPostSubjectPublicationrelationFacade userPostSubjectPublicationrelationFacade;

    @Override
    public void process() {
        try {
            userFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/UserFacade!control.UserFacade");
            userPostSubjectPublicationrelationFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/UserPostSubjectPublicationrelationFacade!control.UserPostSubjectPublicationrelationFacade");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        if ((User) request.getSession().getAttribute("user") == null) {
            List<User> user = userFacade.findByNicknameAndPassword(request.getParameter("nickname"), request.getParameter("password"));
            if (user.size() != 0) {
                request.getSession().setAttribute("user", user.get(0));
                List<Post> postFollowedSubjectByUser = userPostSubjectPublicationrelationFacade.findPostsofFollowedSubjectsByUser((User) request.getSession().getAttribute("user"));
                request.setAttribute("PostsFollowedSubjectsByUser", postFollowedSubjectByUser);
                forward("/MainFrame.jsp");
            } else {
                forward("/index.jsp");
            }
        } else {
            forward("/MainFrame.jsp");
        }
    }

}
