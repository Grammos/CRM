/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import Ejb.Punetori;
import java.util.List;

/**
 *
 * @author Gramos
 */
public interface PunetoriInterface 
{
    void create(Punetori punetori)throws UsersException;
    void edit(Punetori punetori)throws UsersException;
    void remove(Punetori punetori)throws UsersException;
    List<Punetori>findAll();
    Punetori findById(String punetori)throws UsersException;
    Punetori findByEmri(String punetori)throws UsersException;
    Punetori find(String punetori)throws UsersException;
}
