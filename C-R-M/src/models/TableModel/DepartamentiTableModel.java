/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.TableModel;

import Ejb.Departamenti;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Drilon
 */
public class DepartamentiTableModel extends AbstractTableModel
{   
    private String [] columnNames={"Departamenti_id","D_Emri"};
    private List<Departamenti>data;
    
    public DepartamentiTableModel()
    {
    }
    public DepartamentiTableModel(List<Departamenti>data)
    {
        this.data=data;
    }
    public void add(List<Departamenti>data)
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
    public Departamenti getDepartamenti(int index){
           return data.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Departamenti d=(Departamenti)data.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                return d.getDId();
            case 1:
                return d.getDEmri();
            
            default:
                return null;
        }
    }
    
}
