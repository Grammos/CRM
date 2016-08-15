/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.TableModel;

import Ejb.Produkti;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Drilon
 */
public class ProduktiTableModel extends AbstractTableModel
{
    private String [] columnNames={"Produkti_id","Emri","Grupi","Qmimorja_id"};
    private List<Produkti>data;
    
    public ProduktiTableModel()
    {}
    public ProduktiTableModel(List<Produkti>data)
    {
        this.data=data;
    }
    public void add(List<Produkti>data)
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
    public Produkti getProdukti(int index)
    {
        return data.get(index);
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
        Produkti p=(Produkti)data.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                return p.getPid();
            case 1:
                return p.getPEmri();
            case 2:
                return p.getGid();
            case 3:
                return p.getQmimorjaid();
            default:
                return null;
        }
    }
    
}
