package Ejb;

import Ejb.Klienti;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-28T12:09:41")
@StaticMetamodel(Porosia.class)
public class Porosia_ { 

    public static volatile SingularAttribute<Porosia, String> adresa;
    public static volatile SingularAttribute<Porosia, Date> data;
    public static volatile SingularAttribute<Porosia, Klienti> klientiid;
    public static volatile SingularAttribute<Porosia, Integer> pid;
    public static volatile SingularAttribute<Porosia, Integer> sasia;

}