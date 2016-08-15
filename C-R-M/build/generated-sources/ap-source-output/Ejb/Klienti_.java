package Ejb;

import Ejb.GrupiKlientav;
import Ejb.Oferta;
import Ejb.Oppertunities;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-28T12:09:41")
@StaticMetamodel(Klienti.class)
public class Klienti_ { 

    public static volatile SingularAttribute<Klienti, String> telefoni;
    public static volatile SingularAttribute<Klienti, String> kEmri;
    public static volatile SingularAttribute<Klienti, String> kAdresa;
    public static volatile SingularAttribute<Klienti, GrupiKlientav> gKid;
    public static volatile SingularAttribute<Klienti, String> email;
    public static volatile SingularAttribute<Klienti, Oppertunities> oid;
    public static volatile SingularAttribute<Klienti, Oferta> oferta;
    public static volatile SingularAttribute<Klienti, String> kMbiemri;
    public static volatile SingularAttribute<Klienti, Integer> klientiid;
    public static volatile CollectionAttribute<Klienti, Oferta> ofertaCollection;

}