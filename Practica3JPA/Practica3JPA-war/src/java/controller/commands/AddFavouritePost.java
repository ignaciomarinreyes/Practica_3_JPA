package controller.commands;

import control.PostFacade;
import control.SubjectFacade;
import entities.Post;
import entities.Subject;
import entities.User;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class AddFavouritePost extends FrontCommand {

    private PostFacade postFacade;

    @Override
    public void process() {
        try {
            postFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/PostFacade!control.PostFacade");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        User user = (User) request.getSession().getAttribute("user");
        Post post = postFacade.find(new Integer(request.getParameter("idPost")));
        post.addUserCollectionFavourite(user);
        user.addPostCollectionFavourite(post);
        postFacade.edit(post);
        forward("/OperationSuccesful.jsp");
    }

}
