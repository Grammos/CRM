/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.ComboBoxModel;

import Ejb.Departamenti;
import Ejb.Produkti;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Gramos
 */
public class ProduktiComboBoxModel extends AbstractListModel<Produkti> implements ComboBoxModel<Produkti>
{
    private Produkti item;
    private List<Produkti>data;
    
    public ProduktiComboBoxModel(List arrayList)
    {
        data=arrayList;
    }
    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Produkti getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
         item=(Produkti)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return item;
    }
    
}
