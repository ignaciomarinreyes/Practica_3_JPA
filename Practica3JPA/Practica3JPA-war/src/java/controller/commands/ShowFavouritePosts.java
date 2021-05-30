package controller.commands;

import control.UserFacade;
import entities.User;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ShowFavouritePosts extends FrontCommand {
    
    private UserFacade userFacade;

    @Override
    public void process() {
        try {
            userFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/UserFacade!control.UserFacade");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        User user = userFacade.find(((User) request.getSession().getAttribute("user")).getId());
        request.setAttribute("favouritePosts", user.getPostCollectionFavourite());
        forward("/ShowFavouritePosts.jsp");
    }

}
