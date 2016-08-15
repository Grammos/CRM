/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.ComboBoxModel;

import Ejb.Users;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Gramos
 */
public class UsersComboBoxModel extends AbstractListModel<Users> implements ComboBoxModel<Users>
{
    private Users item;
    private List<Users>data;
    
    public UsersComboBoxModel(List arrayList)
    {
      data=arrayList;
    }
    
    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Users getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        item=(Users)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return item;
    }
    
}
