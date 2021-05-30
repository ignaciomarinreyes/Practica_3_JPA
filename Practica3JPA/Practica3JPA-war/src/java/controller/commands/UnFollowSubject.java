package controller.commands;

import control.PostFacade;
import control.SubjectFacade;
import control.UserFacade;
import entities.Subject;
import entities.User;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class UnFollowSubject extends FrontCommand {

    private UserFacade userFacade;
    private SubjectFacade subjectFacade;

    @Override
    public void process() {
        try {
            userFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/UserFacade!control.UserFacade");
            subjectFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/SubjectFacade!control.SubjectFacade");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }        
        User user = (User) request.getSession().getAttribute("user");
        user.unfollowSubject(new Integer(request.getParameter("idFollowedSubject")));
        Subject subject  = subjectFacade.find(new Integer(request.getParameter("idFollowedSubject")));
        subject.unfollowUser(user.getId());
        subjectFacade.edit(subject);
        userFacade.edit(user);
        request.setAttribute("followedSubjects", user.getFollowedSubjects());
        forward("/ShowFollowedSubjects.jsp");
    }

}
