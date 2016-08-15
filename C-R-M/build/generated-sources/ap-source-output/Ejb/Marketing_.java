package Ejb;

import Ejb.Departamenti;
import Ejb.Oferta;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-28T12:09:41")
@StaticMetamodel(Marketing.class)
public class Marketing_ { 

    public static volatile SingularAttribute<Marketing, String> emri;
    public static volatile SingularAttribute<Marketing, Departamenti> departamentiid;
    public static volatile SingularAttribute<Marketing, Integer> mid;
    public static volatile CollectionAttribute<Marketing, Oferta> ofertaCollection;

}