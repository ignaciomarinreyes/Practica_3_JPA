package entities;

import entities.Address;
import entities.Comment;
import entities.Degree;
import entities.Post;
import entities.Rol;
import entities.Subject;
import entities.University;
import entities.UserPostSubjectR;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-22T16:22:16")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Address> address;
    public static volatile SingularAttribute<User, University> university;
    public static volatile CollectionAttribute<User, Comment> commentCollection;
    public static volatile SingularAttribute<User, Degree> degree;
    public static volatile SingularAttribute<User, Rol> rol;
    public static volatile CollectionAttribute<User, Subject> subjectCollection;
    public static volatile SingularAttribute<User, String> password;
    public static volatile CollectionAttribute<User, Post> postCollection;
    public static volatile SingularAttribute<User, String> surname;
    public static volatile CollectionAttribute<User, Subject> subjectCollection1;
    public static volatile SingularAttribute<User, String> nickname;
    public static volatile SingularAttribute<User, String> name;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile CollectionAttribute<User, Post> postCollection1;
    public static volatile CollectionAttribute<User, UserPostSubjectR> userPostSubjectRCollection;

}