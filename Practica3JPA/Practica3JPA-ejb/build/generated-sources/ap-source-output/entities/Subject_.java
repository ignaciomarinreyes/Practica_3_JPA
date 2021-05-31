package entities;

import entities.Degree;
import entities.Post;
import entities.University;
import entities.User;
import entities.UserPostSubjectPublicationrelation;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-31T21:33:41")
@StaticMetamodel(Subject.class)
public class Subject_ { 

    public static volatile CollectionAttribute<Subject, User> userFollowedCollection;
    public static volatile CollectionAttribute<Subject, UserPostSubjectPublicationrelation> userPostSubjectPublicationrelationCollection;
    public static volatile CollectionAttribute<Subject, Post> postCollection;
    public static volatile SingularAttribute<Subject, User> teacher;
    public static volatile SingularAttribute<Subject, University> university;
    public static volatile SingularAttribute<Subject, String> name;
    public static volatile SingularAttribute<Subject, Degree> degree;
    public static volatile SingularAttribute<Subject, Integer> course;
    public static volatile SingularAttribute<Subject, Integer> id;

}