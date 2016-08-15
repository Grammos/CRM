package Ejb;

import Ejb.Punetori;
import Ejb.Role;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-28T12:09:41")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, Integer> uid;
    public static volatile SingularAttribute<Users, String> shfrytezuesi;
    public static volatile SingularAttribute<Users, Role> roleid;
    public static volatile CollectionAttribute<Users, Punetori> punetoriCollection;
    public static volatile SingularAttribute<Users, String> fjalekalimi;

}