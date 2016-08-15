/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import Ejb.Oferta;
import java.util.List;

/**
 *
 * @author Gramos
 */
public interface OfertaInterface {
    void create(Oferta oferta)throws UsersException;
    void edit(Oferta oferta)throws UsersException;
    void remove(Oferta oferta)throws UsersException;
    List<Oferta>findAll();
    Oferta findByEmri(String oferta)throws UsersException;
    
}
