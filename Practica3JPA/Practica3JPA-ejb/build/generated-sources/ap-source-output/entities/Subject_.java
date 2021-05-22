package entities;

import entities.Degree;
import entities.Post;
import entities.University;
import entities.User;
import entities.UserPostSubjectR;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-22T17:14:06")
@StaticMetamodel(Subject.class)
public class Subject_ { 

    public static volatile CollectionAttribute<Subject, Post> postCollection;
    public static volatile SingularAttribute<Subject, User> teacher;
    public static volatile SingularAttribute<Subject, University> university;
    public static volatile CollectionAttribute<Subject, User> userCollection;
    public static volatile SingularAttribute<Subject, String> name;
    public static volatile SingularAttribute<Subject, Degree> degree;
    public static volatile SingularAttribute<Subject, Integer> course;
    public static volatile SingularAttribute<Subject, Integer> id;
    public static volatile CollectionAttribute<Subject, UserPostSubjectR> userPostSubjectRCollection;

}