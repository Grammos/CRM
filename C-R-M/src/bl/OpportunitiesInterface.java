/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import Ejb.Oppertunities;
import java.util.List;

/**
 *
 * @author Gramos
 */
public interface OpportunitiesInterface {
    void create (Oppertunities opportunities )throws UsersException;
    void edit(Oppertunities opportunities)throws UsersException;
    void remove(Oppertunities opportunities)throws UsersException;
    List<Oppertunities>findAll();
}
