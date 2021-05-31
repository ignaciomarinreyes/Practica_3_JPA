package controller.commands;

import control.DegreeFacade;
import entities.Degree;
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
        Integer page = new Integer(request.getParameter("page"));
        List<Degree> degrees = degreeFacade.findByUniversityNameRange5(request.getParameter("searchDegrees"), page);
        Double pages = Math.ceil((double) degreeFacade.findByUniversityName(request.getParameter("searchDegrees")).size() / 5);
        request.setAttribute("degrees", degrees);
        request.setAttribute("numberPages", pages.intValue());
        Integer next = page + 1;
        Integer before = page - 1;
        request.setAttribute("next", (next == pages.intValue() + 1 ? String.valueOf(pages.intValue()) : String.valueOf(next)));
        request.setAttribute("before", (before == 0 ? "1" : String.valueOf(before)));
        forward("/ShowStudies.jsp");
    }

}
