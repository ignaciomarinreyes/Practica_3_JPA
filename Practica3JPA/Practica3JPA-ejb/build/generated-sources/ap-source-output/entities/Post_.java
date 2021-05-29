package entities;

import entities.Comment;
import entities.Subject;
import entities.User;
import entities.UserPostSubjectPublicationrelation;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-29T21:54:29")
@StaticMetamodel(Post.class)
public class Post_ { 

    public static volatile SingularAttribute<Post, Date> date;
    public static volatile CollectionAttribute<Post, UserPostSubjectPublicationrelation> userPostSubjectPublicationrelationCollection;
    public static volatile CollectionAttribute<Post, User> userCollectionFavourite;
    public static volatile SingularAttribute<Post, Subject> subject;
    public static volatile CollectionAttribute<Post, Comment> commentCollection;
    public static volatile CollectionAttribute<Post, User> userCollectionLike;
    public static volatile SingularAttribute<Post, Integer> id;
    public static volatile SingularAttribute<Post, String> title;
    public static volatile SingularAttribute<Post, User> user;
    public static volatile SingularAttribute<Post, String> content;
    public static volatile SingularAttribute<Post, String> pathimage;

}