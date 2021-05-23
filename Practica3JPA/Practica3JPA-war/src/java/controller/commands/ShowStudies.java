package controller.commands;

import control.DegreeFacade;
import control.UserFacade;
import entities.Rol;
import entities.User;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ShowStudies extends FrontCommand {

    private DegreeFacade degreeFacade;

    @Override
    public void process() {
        try {
            degreeFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/DegreeFacade!control.DegreeFacade");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        request.setAttribute("degrees", degreeFacade.findByUniversityName(request.getParameter("searchDegrees")));
        forward("/ShowStudies.jsp");
    }

}
