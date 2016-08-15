package Ejb;

import Ejb.Departamenti;
import Ejb.Kontrata;
import Ejb.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-28T12:09:41")
@StaticMetamodel(Punetori.class)
public class Punetori_ { 

    public static volatile SingularAttribute<Punetori, String> qyteti;
    public static volatile SingularAttribute<Punetori, Users> uid;
    public static volatile SingularAttribute<Punetori, Kontrata> kontrata;
    public static volatile SingularAttribute<Punetori, String> adresa;
    public static volatile SingularAttribute<Punetori, String> emri;
    public static volatile SingularAttribute<Punetori, String> mbiemri;
    public static volatile SingularAttribute<Punetori, Long> telefoni;
    public static volatile SingularAttribute<Punetori, Departamenti> did;
    public static volatile SingularAttribute<Punetori, Integer> pid;
    public static volatile SingularAttribute<Punetori, Kontrata> kontrataid;

}