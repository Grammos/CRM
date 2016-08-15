package Ejb;

import Ejb.Klienti;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-28T12:09:41")
@StaticMetamodel(GrupiKlientav.class)
public class GrupiKlientav_ { 

    public static volatile SingularAttribute<GrupiKlientav, Integer> gKid;
    public static volatile SingularAttribute<GrupiKlientav, String> pershkrimi;
    public static volatile CollectionAttribute<GrupiKlientav, Klienti> klientiCollection;

}