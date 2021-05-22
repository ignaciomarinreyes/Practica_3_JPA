package entities;

import entities.Post;
import entities.Subject;
import entities.User;
import entities.UserPostSubjectRPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-22T16:22:16")
@StaticMetamodel(UserPostSubjectR.class)
public class UserPostSubjectR_ { 

    public static volatile SingularAttribute<UserPostSubjectR, Post> post;
    public static volatile SingularAttribute<UserPostSubjectR, UserPostSubjectRPK> userPostSubjectRPK;
    public static volatile SingularAttribute<UserPostSubjectR, Subject> subject;
    public static volatile SingularAttribute<UserPostSubjectR, User> user;

}