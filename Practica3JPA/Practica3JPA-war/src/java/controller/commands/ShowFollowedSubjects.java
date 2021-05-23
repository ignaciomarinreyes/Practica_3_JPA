package controller.commands;

import control.PostFacade;
import control.SubjectFacade;
import entities.Subject;
import entities.User;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ShowFollowedSubjects extends FrontCommand {

    private SubjectFacade subjectFacade;

    @Override
    public void process() {
        try {
            subjectFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/SubjectFacade!control.SubjectFacade");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("followedSubjects", user.getFollowedSubjects() );
        forward("/ShowFollowedSubjects.jsp");
    }

}
