/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import Ejb.GrupiKlientav;
import java.util.List;

/**
 *
 * @author Gramos
 */
public interface GrupiKlientavInterface 
{
    void create(GrupiKlientav grKlientav)throws UsersException;
    void edit(GrupiKlientav grKlientav)throws UsersException;
    void remove(GrupiKlientav grKlientav)throws UsersException;
    List<GrupiKlientav>findAll();
    
}
