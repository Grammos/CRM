/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.TableModel;

import Ejb.Role;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Drilon
 */
public class RoleTableModel extends AbstractTableModel
{
    private String [] columnNames={"Role_id","Role_Description","Role_Name","Forms"};
    private List<Role>data;
    
    public RoleTableModel()
    {}
    public RoleTableModel(List<Role>data)
    {
        this.data=data;
    }
    public void add(List<Role>data)
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
    public Role getRole(int index)
    {
        return data.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Role r=(Role)data.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                return r.getRoleid();
            case 1:
                return r.getRoleDescripton();
            case 2:
                return r.getRoleName();
            case 3:
                return r.getFormsCollection().iterator();
            default:
                return null;
        
        }
    }
}
