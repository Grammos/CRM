/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import Ejb.OpenLead;
import java.util.List;

/**
 *
 * @author Gramos
 */
public interface OpenLeadInterface {
    void create (OpenLead lead)throws UsersException;
    void edit(OpenLead lead)throws UsersException;
    void remove(OpenLead lead)throws UsersException;
    List<OpenLead>findAll();
    OpenLead  findByEmri (String openLead)throws UsersException;
}
