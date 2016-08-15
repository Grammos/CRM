/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.ComboBoxModel;

import Ejb.OpenLead;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Gramos
 */
public class OpenLeadComboBoxModel extends AbstractListModel<OpenLead> implements ComboBoxModel<OpenLead>
{
    private OpenLead item;
    private List<OpenLead>data;
    
    public OpenLeadComboBoxModel(List ArrayList)
    {
        data=ArrayList;
    }
    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public OpenLead getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        item=(OpenLead)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return item;
    }
    
}
