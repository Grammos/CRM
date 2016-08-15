/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.ComboBoxModel;

import Ejb.Oppertunities;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Gramos
 */
public class OpportunitiesComboBoxModel extends AbstractListModel<Oppertunities> implements ComboBoxModel<Oppertunities> 
{
    private Oppertunities item;
    private List<Oppertunities>data;
    
    public OpportunitiesComboBoxModel()
    {}
    public OpportunitiesComboBoxModel(List arrayList)
    {
        data=arrayList;
    }
    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Oppertunities getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        item=(Oppertunities)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return item;
    }
    
}
