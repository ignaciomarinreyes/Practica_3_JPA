package controller.commands;

import control.DegreeFacade;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class DeleteDegrees extends FrontCommand {

    private DegreeFacade degreeFacade;

    @Override
    public void process() {
        try {
            degreeFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/DegreeFacade!control.DegreeFacade");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        degreeFacade.deleteByName(request.getParameter("deleteDegree"));
        request.setAttribute("degrees", degreeFacade.findAll());
        forward("/ShowDegrees.jsp");
    }

}
