package controller.commands;

import control.PostFacade;
import control.SubjectFacade;
import control.UserFacade;
import entities.Post;
import entities.Subject;
import entities.User;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class AddFavouritePost extends FrontCommand {

    private PostFacade postFacade;
    private UserFacade userFacade;

    @Override
    public void process() {
        try {
            postFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/PostFacade!control.PostFacade");
            userFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/UserFacade!control.UserFacade");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        User user = (User) request.getSession().getAttribute("user");
        Post post = postFacade.find(new Integer(request.getParameter("idPost")));
        post.addUserCollectionFavourite(user);
        user.addPostCollectionFavourite(post);
        try{
            postFacade.edit(post);
            userFacade.edit(user);
        } catch(Exception e){
            post.removeLastUserCollectionFavourite();
            user.removeLastPostCollectionFavourite();
            forward("/OperationFailed2.jsp");
        }
        request.setAttribute("user", userFacade.find(user.getId()));
        forward("/OperationSuccesful.jsp");
    }

}
