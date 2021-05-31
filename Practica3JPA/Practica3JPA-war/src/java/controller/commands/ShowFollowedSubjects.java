package controller.commands;

import entities.User;

public class ShowFollowedSubjects extends FrontCommand {

    @Override
    public void process() {
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("followedSubjects", user.getFollowedSubjects() );
        forward("/ShowFollowedSubjects.jsp");
    }

}
