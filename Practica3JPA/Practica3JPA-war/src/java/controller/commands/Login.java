package controller.commands;

import control.PostFacade;
import entities.User;
import control.UserFacade;
import entities.Post;
import java.util.List;

public class Login extends FrontCommand {

    private UserFacade userFacade;
    private PostFacade postFacade;

    @Override
    public void process() {
        userFacade = new UserFacade();
        postFacade = new PostFacade();
        List<Post> postst = postFacade.findAll();
        System.out.println(postst.size());
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
