/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.ComboBoxModel;

import Ejb.GrupiProduktev;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Gramos
 */
public class GrupiProdukteveComboBoxModel extends AbstractListModel<GrupiProduktev> implements ComboBoxModel<GrupiProduktev>
{
    private GrupiProduktev item;
    private List<GrupiProduktev>data;

    public GrupiProdukteveComboBoxModel(List arrayList)
    {
        data=arrayList;
    }
    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public GrupiProduktev getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        item=(GrupiProduktev)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return item;
    }
    
}
