/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.TableModel;

import Ejb.Qmimorja;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Drilon
 */
public class QmimorjaTableModel extends AbstractTableModel
{   
    private String [] columnNames={"Id","Emri","Qmimi"};
    private List<Qmimorja>data;
    
    public QmimorjaTableModel()
    {
    }
    public QmimorjaTableModel(List<Qmimorja>data)
    {
        this.data=data;
    }
    public void add(List<Qmimorja>data)
    {
        this.data=data;
    }
    @Override
    public int getRowCount() 
    {
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
    public Qmimorja getQmimorja(int index)
    {
        return data.get(index);
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Qmimorja q=(Qmimorja)data.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                return q.getQmimorjaid();
            case 1:
                return q.getEmri();
            case 2:
                return q.getQmimi();
            default:
                return null;
        }
    }
    
}
