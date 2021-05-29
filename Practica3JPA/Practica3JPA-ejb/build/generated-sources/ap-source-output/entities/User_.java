package entities;

import entities.Address;
import entities.Comment;
import entities.Degree;
import entities.Post;
import entities.Rol;
import entities.Subject;
import entities.University;
import entities.UserPostSubjectPublicationrelation;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-29T19:44:22")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Address> address;
    public static volatile SingularAttribute<User, University> university;
    public static volatile CollectionAttribute<User, Comment> commentCollection;
    public static volatile SingularAttribute<User, Degree> degree;
    public static volatile CollectionAttribute<User, Subject> subjectFollowedCollection;
    public static volatile CollectionAttribute<User, Post> postCollectionLike;
    public static volatile CollectionAttribute<User, Post> postCollectionFavourite;
    public static volatile SingularAttribute<User, Rol> rol;
    public static volatile CollectionAttribute<User, UserPostSubjectPublicationrelation> userPostSubjectPublicationrelationCollection;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> surname;
    public static volatile CollectionAttribute<User, Subject> subjectCollection1;
    public static volatile SingularAttribute<User, String> nickname;
    public static volatile SingularAttribute<User, String> name;
    public static volatile CollectionAttribute<User, Post> myPostsCollection;
    public static volatile SingularAttribute<User, Integer> id;

}