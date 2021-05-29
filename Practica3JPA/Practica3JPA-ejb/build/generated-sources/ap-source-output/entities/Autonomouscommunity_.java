package entities;

import entities.Province;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-29T21:54:29")
@StaticMetamodel(Autonomouscommunity.class)
public class Autonomouscommunity_ { 

    public static volatile SingularAttribute<Autonomouscommunity, String> name;
    public static volatile SingularAttribute<Autonomouscommunity, Integer> id;
    public static volatile CollectionAttribute<Autonomouscommunity, Province> provinceCollection;

}