package Ejb;

import Ejb.Klienti;
import Ejb.OpenLead;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-28T12:09:41")
@StaticMetamodel(Oppertunities.class)
public class Oppertunities_ { 

    public static volatile SingularAttribute<Oppertunities, String> emri;
    public static volatile SingularAttribute<Oppertunities, Integer> oid;
    public static volatile CollectionAttribute<Oppertunities, Klienti> klientiCollection;
    public static volatile SingularAttribute<Oppertunities, OpenLead> leadid;

}