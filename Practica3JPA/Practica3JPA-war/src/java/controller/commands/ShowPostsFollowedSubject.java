package controller.commands;

import entities.User;
import control.PostFacade;
import entities.Post;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ShowPostsFollowedSubject extends FrontCommand {

    private PostFacade postFacade;
    
    @Override
    public void process() {
        try {
            postFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/PostFacade!control.PostFacade");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        postFacade = new PostFacade();
        List<Post> posts = postFacade.findPostsFollowedSubject((User) request.getSession().getAttribute("user"));
        request.setAttribute("PostsFollowedSubjectsByUser", posts);
        forward("/MainFrame.jsp");
    }

}
