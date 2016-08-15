/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import Ejb.Porosia;
import java.util.List;

/**
 *
 * @author Gramos
 */
public interface PorosiaInterface
{
    void create (Porosia porosia)throws UsersException;
    void edit(Porosia porosia)throws UsersException;
    void remove(Porosia porosia)throws UsersException;
    List<Porosia>findAll();
}
