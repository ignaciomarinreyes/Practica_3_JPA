package controller.commands;

import entities.User;
import control.PostFacade;
import entities.Post;
import java.util.List;

public class ShowPostsFollowedSubject extends FrontCommand {

    private PostFacade postFacade;
    
    @Override
    public void process() {
        postFacade = new PostFacade();
        List<Post> posts = postFacade.findPostsFollowedSubject((User) request.getSession().getAttribute("user"));
        request.setAttribute("PostsFollowedSubjectsByUser", posts);
        forward("/MainFrame.jsp");
    }

}
