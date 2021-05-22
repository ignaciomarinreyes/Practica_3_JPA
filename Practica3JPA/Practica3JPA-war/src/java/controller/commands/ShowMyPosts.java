package controller.commands;

import control.PostFacade;
import entities.User;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ShowMyPosts extends FrontCommand {

    private PostFacade postFacade;

    @Override
    public void process() {
        try {
            postFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/PostFacade!control.PostFacade");        
        } catch (NamingException ex) {
            ex.printStackTrace();
        }        request.setAttribute("postsMYUser", postFacade.findByUser((User) request.getSession().getAttribute("user")));
        forward("/ShowMyPosts.jsp");
    }

}
