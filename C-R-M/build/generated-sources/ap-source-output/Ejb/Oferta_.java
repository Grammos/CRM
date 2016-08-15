package Ejb;

import Ejb.Klienti;
import Ejb.Marketing;
import Ejb.OpenLead;
import Ejb.Produkti;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-28T12:09:41")
@StaticMetamodel(Oferta.class)
public class Oferta_ { 

    public static volatile SingularAttribute<Oferta, Integer> ofertaid;
    public static volatile SingularAttribute<Oferta, String> ofertaEmri;
    public static volatile CollectionAttribute<Oferta, OpenLead> openLeadCollection;
    public static volatile SingularAttribute<Oferta, Klienti> klientiid;
    public static volatile SingularAttribute<Oferta, Long> qmimiOfertues;
    public static volatile SingularAttribute<Oferta, Produkti> pid;
    public static volatile SingularAttribute<Oferta, Marketing> mid;
    public static volatile CollectionAttribute<Oferta, Klienti> klientiCollection;

}