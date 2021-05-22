package controller.commands;

import control.DegreeFacade;
import control.SubjectFacade;
import control.UniversityFacade;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class SearchSubject extends FrontCommand {

    private UniversityFacade universityFacade;
    private DegreeFacade degreeFacade;
    private SubjectFacade SubjectFacade;

    @Override
    public void process() {
        try {
            universityFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/UniversityFacade!control.UniversityFacade");
            degreeFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/DegreeFacade!control.DegreeFacade");
            SubjectFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/SubjectFacade!control.SubjectFacade");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        request.setAttribute("universities", universityFacade.findAll());
        request.setAttribute("degrees", degreeFacade.findAll());
        request.setAttribute("subjects", SubjectFacade.findAll());
        forward("/SearchSubject.jsp");
    }
}
