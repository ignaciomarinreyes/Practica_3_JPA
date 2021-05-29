package entities;

import entities.Address;
import entities.Degree;
import entities.Subject;
import entities.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-29T21:54:29")
@StaticMetamodel(University.class)
public class University_ { 

    public static volatile CollectionAttribute<University, Subject> subjectCollection;
    public static volatile CollectionAttribute<University, Degree> degreeCollection;
    public static volatile SingularAttribute<University, Address> address;
    public static volatile CollectionAttribute<University, User> userCollection;
    public static volatile SingularAttribute<University, String> name;
    public static volatile SingularAttribute<University, Integer> id;

}