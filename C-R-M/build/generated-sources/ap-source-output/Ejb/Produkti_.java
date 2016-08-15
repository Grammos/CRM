package Ejb;

import Ejb.GrupiProduktev;
import Ejb.Oferta;
import Ejb.Qmimorja;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-28T12:09:41")
@StaticMetamodel(Produkti.class)
public class Produkti_ { 

    public static volatile SingularAttribute<Produkti, String> pEmri;
    public static volatile SingularAttribute<Produkti, GrupiProduktev> gid;
    public static volatile SingularAttribute<Produkti, Integer> pid;
    public static volatile CollectionAttribute<Produkti, Oferta> ofertaCollection;
    public static volatile SingularAttribute<Produkti, Qmimorja> qmimorjaid;

}