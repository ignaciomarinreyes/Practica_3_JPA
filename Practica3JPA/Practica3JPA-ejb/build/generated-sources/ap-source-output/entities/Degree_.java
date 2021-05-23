package entities;

import entities.Subject;
import entities.University;
import entities.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-23T20:09:51")
@StaticMetamodel(Degree.class)
public class Degree_ { 

    public static volatile CollectionAttribute<Degree, Subject> subjectCollection;
    public static volatile SingularAttribute<Degree, University> university;
    public static volatile CollectionAttribute<Degree, User> userCollection;
    public static volatile SingularAttribute<Degree, String> name;
    public static volatile SingularAttribute<Degree, Integer> id;

}