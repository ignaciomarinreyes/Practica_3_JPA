package entities;

import entities.Post;
import entities.Subject;
import entities.User;
import entities.UserPostSubjectPublicationrelationPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-23T20:09:51")
@StaticMetamodel(UserPostSubjectPublicationrelation.class)
public class UserPostSubjectPublicationrelation_ { 

    public static volatile SingularAttribute<UserPostSubjectPublicationrelation, UserPostSubjectPublicationrelationPK> userPostSubjectPublicationrelationPK;
    public static volatile SingularAttribute<UserPostSubjectPublicationrelation, Post> post;
    public static volatile SingularAttribute<UserPostSubjectPublicationrelation, Subject> subject;
    public static volatile SingularAttribute<UserPostSubjectPublicationrelation, User> user;

}