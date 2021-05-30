package controller.commands;

import control.PostFacade;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ShowPosts extends FrontCommand {

    private PostFacade postFacade;

    @Override
    public void process() {
        try {
            postFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/PostFacade!control.PostFacade");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        request.setAttribute("posts", postFacade.findAll());
        forward("/ShowPosts.jsp");
    }

}
