/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.TableModel;

import Ejb.Users;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Drilon
 */
public class UsersTableModel extends AbstractTableModel
{
    private String [] columnNames={"U_id","Shfrytezuesi","Fjalekalimi","Role_id"};
    private List<Users>data;
    public UsersTableModel()
    {}
    public UsersTableModel(List<Users>data)
    {
        this.data=data;
    }
    public void add(List<Users>data)
    {
        this.data=data;
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    public void remove(int row)
    {
        data.remove(row);
    }
    public Users getUsers(int index){
           return data.get(index);
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Users u=(Users)data.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                return u.getUid();
            case 1:
                return u.getShfrytezuesi();
            case 2:
                return u.getFjalekalimi();
            case 3:
                return u.getRoleid();
            default:
                return null;
        }
    }
    
}
