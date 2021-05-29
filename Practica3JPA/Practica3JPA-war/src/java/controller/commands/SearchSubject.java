package controller.commands;

import control.DegreeFacade;
import control.SubjectFacade;
import control.UniversityFacade;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class SearchSubject extends FrontCommand {

    private DegreeFacade degreeFacade;

    @Override
    public void process() {
        try {
            degreeFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/DegreeFacade!control.DegreeFacade");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        request.setAttribute("subjects", degreeFacade.find(new Integer(request.getParameter("degrees"))).getSubjectCollection());
        forward("/SearchSubject.jsp");
    }
}
