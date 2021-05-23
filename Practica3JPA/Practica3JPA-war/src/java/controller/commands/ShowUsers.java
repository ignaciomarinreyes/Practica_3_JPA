package controller.commands;

import control.UserFacade;
import entities.Rol;
import entities.User;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ShowUsers extends FrontCommand {

    private UserFacade userFacade;

    @Override
    public void process() {
        try {
            userFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/UserFacade!control.UserFacade");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        request.setAttribute("users", userFacade.findByNameOrNicknameOrPasswordOrSurnameLikeOrderByIdDescd(request.getParameter("searchUsers")));
        forward("/ShowUsers.jsp");
    }

}
