/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import Ejb.Role;
import java.util.List;

/**
 *
 * @author Gramos
 */
public interface RoleInterface 
{
    void create(Role role)throws UsersException;
    void edit (Role role)throws UsersException;
    void remove(Role role)throws UsersException;
    List<Role>findAll();
    Role findById (String role)throws UsersException;
    Role findByKEmri(String role)throws UsersException;
}
