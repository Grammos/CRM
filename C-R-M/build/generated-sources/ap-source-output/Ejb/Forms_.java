package Ejb;

import Ejb.Role;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-28T12:09:41")
@StaticMetamodel(Forms.class)
public class Forms_ { 

    public static volatile SingularAttribute<Forms, Integer> fid;
    public static volatile SingularAttribute<Forms, String> fDescription;
    public static volatile CollectionAttribute<Forms, Role> roleCollection;

}