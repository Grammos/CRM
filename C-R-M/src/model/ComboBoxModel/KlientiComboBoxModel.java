/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.ComboBoxModel;


import Ejb.Klienti;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Gramos
 */
public class KlientiComboBoxModel extends AbstractListModel<Klienti> implements ComboBoxModel<Klienti>
{
    private Klienti item;
    private List<Klienti>data;

    public KlientiComboBoxModel(List arrayList)
    {
        data=arrayList;
    }
    @Override
    public int getSize()
    {
       return data.size();
    }
   
    @Override
    public Klienti getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        item=(Klienti)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return item;
    }

}