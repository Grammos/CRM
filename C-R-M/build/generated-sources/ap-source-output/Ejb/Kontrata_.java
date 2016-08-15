package Ejb;

import Ejb.Punetori;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-28T12:09:41")
@StaticMetamodel(Kontrata.class)
public class Kontrata_ { 

    public static volatile SingularAttribute<Kontrata, Integer> kontrataId;
    public static volatile SingularAttribute<Kontrata, Integer> paga;
    public static volatile SingularAttribute<Kontrata, String> emri;
    public static volatile SingularAttribute<Kontrata, String> kompania;
    public static volatile SingularAttribute<Kontrata, Punetori> punetori;
    public static volatile SingularAttribute<Kontrata, String> pozita;
    public static volatile SingularAttribute<Kontrata, Date> data;
    public static volatile CollectionAttribute<Kontrata, Punetori> punetoriCollection;

}