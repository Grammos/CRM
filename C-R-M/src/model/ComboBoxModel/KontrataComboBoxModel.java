/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.ComboBoxModel;

import Ejb.Kontrata;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Gramos
 */
public class KontrataComboBoxModel extends AbstractListModel<Kontrata> implements ComboBoxModel<Kontrata>
{
    private Kontrata item;
    private List<Kontrata>data;
    
    public KontrataComboBoxModel(List arrayList)
    {
        data=arrayList;
    }
    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Kontrata getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        item=(Kontrata)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return item;
    }
    
}
