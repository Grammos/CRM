/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.TableModel;

import Ejb.Oppertunities;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Drilon
 */
public class OpportunitiesTableModel extends AbstractTableModel
{
    private String [] columnNames={"Id","Emri","Lead id"};
    private List<Oppertunities>data;
    
    public OpportunitiesTableModel()
    {}
    public OpportunitiesTableModel(List<Oppertunities>data)
    {
        this.data=data;
    }
    public void add(List<Oppertunities>data)
    {
        this.data=data;
    }
    @Override
    public int getRowCount() {
        return data.size();
    }
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    public void remove(int row)
    {
        data.remove(row);
    }
    public Oppertunities getOpportunities(int index)
    {
        return data.get(index);
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Oppertunities o=(Oppertunities)data.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                return o.getOid();
            case 1:
                return o.getEmri();
            case 2:
                return o.getLeadid();
            default:
                return null;
        }   
    }
    
}
