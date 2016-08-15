/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import Ejb.Klienti;
import java.util.List;

/**
 *
 * @author Gramos
 */
public interface KlientiInterface 
{
    void create (Klienti klienti)throws UsersException;
    void edit(Klienti klienti)throws UsersException;
    void remove(Klienti klienti)throws UsersException;
    List<Klienti>findAll();
    Klienti findById(String klienti)throws UsersException;
    Klienti findByKEmri(String klienti)throws UsersException;
}
