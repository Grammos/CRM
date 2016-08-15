/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import Ejb.Users;
import java.util.List;

/**
 *
 * @author Gramos
 */
public interface UsersInterface 
{
    void create(Users users)throws UsersException;
    void edit (Users users)throws UsersException;
    void remove (Users users)throws UsersException;
    List<Users> findAll();
    Users findById(String users)throws UsersException;
    Users findByUsername(String username,String password)throws UsersException;
    Users findByUser(String username)throws UsersException;
}
