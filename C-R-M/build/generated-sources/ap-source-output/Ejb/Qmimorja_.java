package Ejb;

import Ejb.Produkti;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-28T12:09:41")
@StaticMetamodel(Qmimorja.class)
public class Qmimorja_ { 

    public static volatile SingularAttribute<Qmimorja, String> emri;
    public static volatile CollectionAttribute<Qmimorja, Produkti> produktiCollection;
    public static volatile SingularAttribute<Qmimorja, Long> qmimi;
    public static volatile SingularAttribute<Qmimorja, Integer> qmimorjaid;

}