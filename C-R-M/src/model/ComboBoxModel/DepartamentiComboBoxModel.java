/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.ComboBoxModel;

import Ejb.Departamenti;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Gramos
 */
public class DepartamentiComboBoxModel extends AbstractListModel<Departamenti> implements ComboBoxModel<Departamenti>
{
    private Departamenti item;
    private List<Departamenti>data;
    
    public DepartamentiComboBoxModel(List arrayList)
    {
        data=arrayList;
    }
    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Departamenti getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        item=(Departamenti)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return item;
    }    
}
