/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import Ejb.Kontrata;
import java.util.List;

/**
 *
 * @author Gramos
 */
public interface KontrataInterface {
    void create (Kontrata kontrata)throws UsersException;
    void edit (Kontrata kontrata)throws UsersException;
    void remove(Kontrata kontrata)throws UsersException;
    List<Kontrata>findAll();
    Kontrata findByKEmri(String kontrata)throws UsersException;
}
