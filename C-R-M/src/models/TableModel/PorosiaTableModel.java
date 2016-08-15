/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.TableModel;

import Ejb.Porosia;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Drilon
 */
public class PorosiaTableModel extends AbstractTableModel
{
    private final String  [] columnNames={"P_id","Sasia","Adresa","Data","Klienti_id"};
    private List <Porosia> data;
    
    public PorosiaTableModel()
    {}
    public PorosiaTableModel(List<Porosia>data)
    {
        this.data=data;
    }
    public void add(List<Porosia>data)
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
    public Porosia getPorosia(int index)
    {
        return data.get(index);
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Porosia p=(Porosia)data.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                return p.getPid();
            case 1:
                return p.getSasia();
            case 2:
                return p.getAdresa();
            case 3:
                return p.getData();
            case 4:
                return p.getKlientiid();
            default:
                return null;
        }   
    }
    
}
