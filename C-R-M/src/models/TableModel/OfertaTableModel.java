/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.TableModel;

import Ejb.Oferta;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Drilon
 */
public class OfertaTableModel extends AbstractTableModel
{
    private String [] columnNames={"Oferta id","Emri","QmimiOfertues","Klienti","Produkti id","Marketing id"};
    private List<Oferta>data;
    
    
    public OfertaTableModel()
    {
    }
    public OfertaTableModel(List<Oferta>data)
    {
        this.data=data;
    }
    public void add(List<Oferta>data)
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
    public Oferta getOferta(int index){
           return data.get(index);
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Oferta o=(Oferta)data.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                return o.getOfertaid();
            case 1:
                return o.getOfertaEmri();
            case 2:
                return o.getQmimiOfertues();
            case 3: 
                return o.getKlientiid();
            case 4:
                return o.getPid();
            case 5:
                return o.getMid();
            default:
                return null;
        }
    }
    
}
