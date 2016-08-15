/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.TableModel;

import Ejb.Forms;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Drilon
 */
public class FormsTableModel extends    AbstractTableModel
{
    private String [] columnNames={"Form id","Form Description"};
    private List<Forms>data;
    
    public FormsTableModel()
    {}
    
    public FormsTableModel(List<Forms>data)
    {
        this.data=data;
    }
    public void add(List<Forms>data)
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
    public Forms getForms(int index){
           return data.get(index);
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Forms f=(Forms)data.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                return f.getFid();
            case 1:
                return f.getFDescription();
            default:
                return null;
        }
        
    }
}
