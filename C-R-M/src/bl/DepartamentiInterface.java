/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import Ejb.Departamenti;
import java.util.List;

/**
 *
 * @author Gramos
 */
public interface DepartamentiInterface 
{
    void create(Departamenti departamenti)throws UsersException;
    void edit(Departamenti departamenti)throws UsersException;
    void remove(Departamenti departamenti)throws UsersException;
    List<Departamenti>findAll();
    Departamenti findById(String departamenti)throws UsersException;   
    Departamenti findByEmri(String departamenti)throws UsersException;
}
