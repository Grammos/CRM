/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import Ejb.Marketing;
import java.util.List;

/**
 *
 * @author Gramos
 */
public interface MarketingInterface 
{
    void create(Marketing marketing) throws UsersException;
    void edit(Marketing marketing) throws UsersException;
    void remove(Marketing marketing)throws UsersException;
    List<Marketing>findAll();
}
