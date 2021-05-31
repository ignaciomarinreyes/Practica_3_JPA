package controller.commands;

import control.UniversityFacade;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class SearchDegree extends FrontCommand {

    private UniversityFacade universityFacade;

    @Override
    public void process() {
        try {
            universityFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/UniversityFacade!control.UniversityFacade");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        request.setAttribute("degrees", universityFacade.find(new Integer(request.getParameter("universities"))).getDegreeCollection());
        forward("/SearchDegree.jsp");
    }
}
