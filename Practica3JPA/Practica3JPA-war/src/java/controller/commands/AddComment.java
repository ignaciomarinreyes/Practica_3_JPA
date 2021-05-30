package controller.commands;

import control.AutonomouscommunityFacade;
import control.CommentFacade;
import control.PostFacade;
import control.ProvinceFacade;
import entities.Comment;
import entities.Post;
import entities.Province;
import entities.User;
import java.sql.Timestamp;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class AddComment extends FrontCommand {

    private CommentFacade commentFacade;
    private PostFacade postFacade;

    @Override
    public void process() {
        try {
            commentFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/CommentFacade!control.CommentFacade");
            postFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/PostFacade!control.PostFacade");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        Post post = postFacade.find(new Integer(request.getParameter("idPostComment")));
        Comment comment = new Comment(request.getParameter("comment"), new Timestamp(System.currentTimeMillis()), post , (User) request.getSession().getAttribute("user"));
        commentFacade.create(comment);
        post.addCommentCollection(comment);
        postFacade.edit(post);
        forward("/OperationSuccesful.jsp");
    }

}
