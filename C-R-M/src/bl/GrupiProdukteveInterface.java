/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import Ejb.GrupiProduktev;
import java.util.List;

/**
 *
 * @author Gramos
 */
public interface GrupiProdukteveInterface
{
    void create(GrupiProduktev grupiProdukteve)throws UsersException;
    void edit(GrupiProduktev grupiProdukteve)throws UsersException;
    void remove(GrupiProduktev grupiProdukteve)throws UsersException;
    List <GrupiProduktev>findAll();
}
