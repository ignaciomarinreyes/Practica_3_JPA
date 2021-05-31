package entities;

import entities.Province;
import entities.ZipCode;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-31T21:33:41")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, String> number;
    public static volatile SingularAttribute<Address, ZipCode> zipCode;
    public static volatile SingularAttribute<Address, Province> province;
    public static volatile SingularAttribute<Address, String> street;
    public static volatile SingularAttribute<Address, Integer> id;

}