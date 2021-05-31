package controller.commands;

import control.PostFacade;
import control.SubjectFacade;
import control.UserFacade;
import entities.Subject;
import entities.User;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class FollowSubject extends FrontCommand {

    private SubjectFacade subjectFacade;
    private PostFacade postFacade;
    private UserFacade userFacade;


    @Override
    public void process() {
        try {
            postFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/PostFacade!control.PostFacade");        
            subjectFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/SubjectFacade!control.SubjectFacade");
            userFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/UserFacade!control.UserFacade");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        Subject subject = (Subject) request.getSession().getAttribute("subjectChoosen");
        User user = (User) request.getSession().getAttribute("user");
        user.addSubjectFollowedCollection(subject);
        subject.addUserFollowedCollection(user);
        subjectFacade.edit(subject);
        userFacade.edit(user);
        request.getSession().setAttribute("subjectChoosen", subject);
        request.getSession().setAttribute("user", user);
        request.setAttribute("followedSubject", subject.isFollowedSubject((User)request.getSession().getAttribute("user")));
        request.setAttribute("PostBySubject", postFacade.findPostsBySubject(subject.getId()));
        forward("/ShowPostsSubject.jsp");
    }
}
