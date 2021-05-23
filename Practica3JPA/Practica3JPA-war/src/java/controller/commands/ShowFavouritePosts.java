package controller.commands;

import entities.User;

public class ShowFavouritePosts extends FrontCommand {

    @Override
    public void process() {
        request.setAttribute("favouritePosts", ((User) request.getSession().getAttribute("user")).getPostCollectionFavourite());
        forward("/ShowFavouritePosts.jsp");
    }

}
