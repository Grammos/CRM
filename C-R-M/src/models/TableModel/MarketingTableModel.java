/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.TableModel;

import Ejb.Marketing;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Drilon
 */
public class MarketingTableModel extends AbstractTableModel
{
    private String [] columnNames={"Id","Emri","Departamenti"};
    private List<Marketing>data;
    
     public MarketingTableModel ()
    {}
    public MarketingTableModel(List<Marketing>data)
    {
        this.data=data;
    }
    public void add(List<Marketing> data)
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
    public void remove (int row)
    {
        data.remove(row);
    }
    public Marketing getMarketing(int index )
    {
        return data.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         Marketing m=(Marketing) data.get(rowIndex);
         switch(columnIndex)
        {
            case 0:
                return m.getMid();
            case 1:
                return m.getEmri();
            case 2:
                return m.getDepartamentiid();  
            default :
                return null;
        }
    }
    
}
