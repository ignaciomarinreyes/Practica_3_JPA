package controller.commands;

import control.DegreeFacade;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class UpdateDegrees extends FrontCommand {

    private DegreeFacade degreeFacade;

    @Override
    public void process() {
        try {
            degreeFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/DegreeFacade!control.DegreeFacade");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        degreeFacade.updateName(request.getParameter("updateDegreeOld"), request.getParameter("updatedDegreeNew"));
        request.setAttribute("degrees", degreeFacade.findAll());
        forward("/ShowDegrees.jsp");
    }

}
