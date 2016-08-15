/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.ComboBoxModel;


import Ejb.Qmimorja;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Gramos
 */
public class QmimorjaComboBoxModel extends AbstractListModel<Qmimorja> implements ComboBoxModel<Qmimorja>
{
    private Qmimorja item;
    private List<Qmimorja>data;
    
    public QmimorjaComboBoxModel(List arrayList)
    {
        data=arrayList;
    }
    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Qmimorja getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        item=(Qmimorja)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return item;
    }
    
}
