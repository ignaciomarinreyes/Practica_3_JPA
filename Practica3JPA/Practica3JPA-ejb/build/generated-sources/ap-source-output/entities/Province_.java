package entities;

import entities.Address;
import entities.Autonomouscommunity;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-30T00:28:44")
@StaticMetamodel(Province.class)
public class Province_ { 

    public static volatile CollectionAttribute<Province, Address> addressCollection;
    public static volatile SingularAttribute<Province, Autonomouscommunity> autonomouscommunity;
    public static volatile SingularAttribute<Province, String> name;
    public static volatile SingularAttribute<Province, Integer> id;

}