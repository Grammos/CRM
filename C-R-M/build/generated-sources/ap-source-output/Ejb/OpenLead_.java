package Ejb;

import Ejb.Oferta;
import Ejb.Oppertunities;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-28T12:09:41")
@StaticMetamodel(OpenLead.class)
public class OpenLead_ { 

    public static volatile SingularAttribute<OpenLead, String> qyteti;
    public static volatile SingularAttribute<OpenLead, String> kompania;
    public static volatile SingularAttribute<OpenLead, String> emri;
    public static volatile SingularAttribute<OpenLead, Long> telefoni;
    public static volatile SingularAttribute<OpenLead, Oferta> ofertaid;
    public static volatile SingularAttribute<OpenLead, String> mbiemri;
    public static volatile SingularAttribute<OpenLead, String> email;
    public static volatile SingularAttribute<OpenLead, String> shteti;
    public static volatile SingularAttribute<OpenLead, Long> zipCode;
    public static volatile SingularAttribute<OpenLead, String> rruga;
    public static volatile CollectionAttribute<OpenLead, Oppertunities> oppertunitiesCollection;
    public static volatile SingularAttribute<OpenLead, String> leadStatus;
    public static volatile SingularAttribute<OpenLead, Integer> leadid;

}