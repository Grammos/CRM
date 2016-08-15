/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.ComboBoxModel;

import Ejb.Oferta;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Gramos
 */
public class OfertaComboBoxModel extends AbstractListModel<Oferta> implements ComboBoxModel<Oferta>
{
    private Oferta item;
    private List<Oferta>data;
        
    public OfertaComboBoxModel(List arraylist)
    {
        data=arraylist;
    }
    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Oferta getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        item=(Oferta)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return item;
    }
    
}
