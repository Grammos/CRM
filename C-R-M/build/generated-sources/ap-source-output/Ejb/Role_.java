package Ejb;

import Ejb.Forms;
import Ejb.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-28T12:09:41")
@StaticMetamodel(Role.class)
public class Role_ { 

    public static volatile SingularAttribute<Role, String> roleDescripton;
    public static volatile SingularAttribute<Role, Integer> roleid;
    public static volatile CollectionAttribute<Role, Users> usersCollection;
    public static volatile SingularAttribute<Role, String> roleName;
    public static volatile CollectionAttribute<Role, Forms> formsList;

}