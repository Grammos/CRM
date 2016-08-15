/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import Ejb.Qmimorja;
import java.util.List;

/**
 *
 * @author Gramos
 */
public interface QmimorjaInterface {
    void create(Qmimorja qmimorja)throws UsersException;
    void edit(Qmimorja qmimorja)throws UsersException;
    void remove(Qmimorja qmimorja)throws UsersException;
    List<Qmimorja>findAll();
}
