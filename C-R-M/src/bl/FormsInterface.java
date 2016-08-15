/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import Ejb.Forms;
import java.util.List;

/**
 *
 * @author Gramos
 */
public interface FormsInterface
{
    void create(Forms forms)throws UsersException;
    void edit(Forms forms)throws UsersException;
    void remove(Forms forms)throws UsersException;
    List <Forms>findAll();
    Forms findById(String forms)throws UsersException;
}
