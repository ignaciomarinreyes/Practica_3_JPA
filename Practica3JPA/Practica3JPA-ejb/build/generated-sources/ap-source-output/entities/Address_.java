package entities;

import entities.University;
import entities.User;
import entities.ZipCode;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-23T13:07:45")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, String> number;
    public static volatile SingularAttribute<Address, String> street;
    public static volatile SingularAttribute<Address, University> university;
    public static volatile SingularAttribute<Address, String> autonomouscommunity;
    public static volatile SingularAttribute<Address, Integer> id;
    public static volatile SingularAttribute<Address, ZipCode> cp;
    public static volatile SingularAttribute<Address, User> user;

}