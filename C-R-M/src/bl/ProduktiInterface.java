/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import Ejb.Produkti;
import java.util.List;

/**
 *
 * @author Gramos
 */
public interface ProduktiInterface {
    void create(Produkti produkti)throws UsersException;
    void edit(Produkti produkti)throws UsersException;
    void remove(Produkti produkti)throws UsersException;
    List<Produkti>findAll();
    Produkti findByEmri(String produkti)throws UsersException;
}
