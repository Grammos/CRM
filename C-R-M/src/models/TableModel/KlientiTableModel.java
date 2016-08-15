/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.TableModel;

import Ejb.Klienti;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Drilon
 */
public class KlientiTableModel extends  AbstractTableModel
{
    private String [] columnNames={"Id","Emri","Mbiemri","Adresa","Email","Telefoni","G_Kid","Opportunitites","Oferta"};
    private List<Klienti>data;
     
    public KlientiTableModel ()
    {}
    public KlientiTableModel(List<Klienti>data)
    {
        this.data=data;
    }
    public void add(List<Klienti> data)
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
    public Klienti getKlienti(int index )
    {
        return data.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Klienti k=(Klienti) data.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                return k.getKlientiid();
            case 1:
                return k.getKEmri();
            case 2:
                return k.getKMbiemri();
            case 3:
                return k.getKAdresa();
            case 4:
                return k.getEmail();
            case 5:
               return  k.getTelefoni();
            case 6:
                return k.getGKid();
            case 7:
                return k.getOid();
            case 8:
                return k.getOferta();
            default :
                return null;
        }
    }
    
}
