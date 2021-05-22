package controller.commands;

import control.PostFacade;
import entities.User;
import control.UserFacade;
import entities.Post;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Login extends FrontCommand {

    private UserFacade userFacade;
    private PostFacade postFacade;

    @Override
    public void process() {
        try {
            userFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/UserFacade!control.UserFacade");
            postFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/PostFacade!control.PostFacade");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        if ((User) request.getSession().getAttribute("user") == null) {
            List<User> user = userFacade.findByNicknameAndPassword(request.getParameter("nickname"), request.getParameter("password"));
            if (user.size() != 0) {
                request.getSession().setAttribute("user", user.get(0));
                List<Post> posts = postFacade.findPostsFollowedSubject((User) request.getSession().getAttribute("user"));
                request.setAttribute("PostsFollowedSubjectsByUser", posts);
                forward("/MainFrame.jsp");
            } else {
                forward("/index.jsp");
            }
        } else {
            forward("/MainFrame.jsp");
        }
    }

}
