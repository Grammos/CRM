package Ejb;

import Ejb.Marketing;
import Ejb.Punetori;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-28T12:09:41")
@StaticMetamodel(Departamenti.class)
public class Departamenti_ { 

    public static volatile CollectionAttribute<Departamenti, Punetori> punetoriCollection;
    public static volatile SingularAttribute<Departamenti, String> dEmri;
    public static volatile CollectionAttribute<Departamenti, Marketing> marketingCollection;
    public static volatile SingularAttribute<Departamenti, Integer> dId;

}