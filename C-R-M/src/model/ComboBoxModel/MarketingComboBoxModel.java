/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.ComboBoxModel;

import Ejb.Marketing;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Gramos
 */
public class MarketingComboBoxModel extends AbstractListModel<Marketing> implements ComboBoxModel<Marketing>
{
    private Marketing item;
    private List<Marketing>data;
    
    public MarketingComboBoxModel(List arraylist)
    {
        data=arraylist;
    }
    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Marketing getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        item=(Marketing)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return item;
    }
    
}
