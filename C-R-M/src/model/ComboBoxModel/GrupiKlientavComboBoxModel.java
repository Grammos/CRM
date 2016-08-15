/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.ComboBoxModel;


import Ejb.GrupiKlientav;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

    
/**
 *
 * @author Gramos
 */
public class GrupiKlientavComboBoxModel extends AbstractListModel<GrupiKlientav> implements ComboBoxModel<GrupiKlientav>
{
    private GrupiKlientav item;
    private List<GrupiKlientav>data;
    
    public GrupiKlientavComboBoxModel(List arrayList)
    {
        data=arrayList;
    }
    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public GrupiKlientav getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        item=(GrupiKlientav)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return item;
    }
    
}
