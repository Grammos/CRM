/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.TableModel;

import Ejb.GrupiKlientav;
import java.util.List;
import javax.swing.table.AbstractTableModel;
 

/**
 *
 * @author Drilon
 */
public class GrupiKlientavTableModel extends AbstractTableModel
{
    private final String [] columnNames={"Id","Pershkrimi"};
    private List<GrupiKlientav>data;
    
    public GrupiKlientavTableModel()
    {}
    public GrupiKlientavTableModel(List<GrupiKlientav>data)
    {
        this.data=data;
    }
    public void add(List<GrupiKlientav>data)
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
    public GrupiKlientav getGrupiKlientav(int index){
           return data.get(index);
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GrupiKlientav gk=(GrupiKlientav)data.get(rowIndex);
        switch(columnIndex)
        {
             case 0:
                return gk.getGKid();
            case 1:
                return gk.getPershkrimi();
            default:
                return null;
        }
    }
    
}
