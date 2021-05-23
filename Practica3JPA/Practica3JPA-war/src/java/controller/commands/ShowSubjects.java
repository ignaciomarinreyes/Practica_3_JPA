package controller.commands;

import control.SubjectFacade;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ShowSubjects extends FrontCommand {

    private SubjectFacade subjectFacade;
    
    @Override
    public void process() {
        try {
            subjectFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/SubjectFacade!control.SubjectFacade");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        request.setAttribute("subjects", subjectFacade.findAll());
        forward("/ShowSubjects.jsp");
    }

}
