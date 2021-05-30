package controller.commands;

import control.PostFacade;
import control.UserFacade;
import entities.Post;
import entities.User;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class GiveLike extends FrontCommand {

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
        User user = (User) request.getSession().getAttribute("user");
        Post post = postFacade.find(new Integer(request.getParameter("idPost")));
        post.addUserCollectionLike(user);
        user.addPostCollectionLike(post);
        try{
            postFacade.edit(post);
            userFacade.edit(user);
        } catch(Exception e){
            post.removeLastUserCollectionLike();
            user.removeLastPostCollectionLike();
            forward("/OperationFailed3.jsp");
        }
        request.setAttribute("user", userFacade.find(user.getId()));
        forward("/OperationSuccesful.jsp");
    }
}
