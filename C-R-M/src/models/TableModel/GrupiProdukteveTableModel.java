/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.TableModel;

import Ejb.GrupiProduktev;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Drilon
 */
public class GrupiProdukteveTableModel extends AbstractTableModel
{
    private String [] columNames={"Id","Pershkrimi"};
    private List<GrupiProduktev> data;
    
    public GrupiProdukteveTableModel()
    {}
    public GrupiProdukteveTableModel(List<GrupiProduktev>data)
    {
        this.data=data;
    }
    public void add(List<GrupiProduktev>data)
    {
        this.data=data;
    }
    public void remove(int row)
    {
        data.remove(row);
    }
    @Override
    public int getRowCount() 
    {
      return  data.size();
    }

    @Override
    public int getColumnCount() {
        return columNames.length;
    }
    @Override
     public String getColumnName(int col) {
        return columNames[col];
    }
    public GrupiProduktev grupiProduktev(int index)
    {
        return data.get(index);
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GrupiProduktev gp=(GrupiProduktev)data.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                return gp.getGid();
            case 1:
                return gp.getPershkrimi();
            default:
                return null;
        }
    }
    
}
