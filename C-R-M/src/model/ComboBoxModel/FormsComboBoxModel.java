/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.ComboBoxModel;

import Ejb.Forms;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Gramos
 */
public class FormsComboBoxModel extends AbstractListModel<Forms> implements ComboBoxModel<Forms>
{
    private Forms item;
    private List<Forms>data;
    
    public FormsComboBoxModel(List arrayList)
    {
        data=arrayList;
    }
    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Forms getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        item=(Forms)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return item;
    }
    
}
