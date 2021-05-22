package controller.commands;

import control.PostFacade;
import control.SubjectFacade;
import entities.Subject;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ShowPostsSubject extends FrontCommand {

    private PostFacade postFacade;
    private SubjectFacade subjectFacade;

    @Override
    public void process() {
        try {
            postFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/PostFacade!control.PostFacade");        
            subjectFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/SubjectFacade!control.SubjectFacade");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        request.setAttribute("PostBySubject", postFacade.findPostsBySubject(new Integer(request.getParameter("subjects"))));
        Subject subject = subjectFacade.find(new Integer(request.getParameter("subjects")));
        request.getSession().setAttribute("subjectChoosen", subject);
        forward("/ShowPostsSubject.jsp");
    }

}
