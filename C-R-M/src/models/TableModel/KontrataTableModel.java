/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.TableModel;


import Ejb.Kontrata;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.apache.poi.ss.usermodel.DataFormat;

/**
 *
 * @author Drilon
 */
public class KontrataTableModel extends AbstractTableModel
{
    private String [] columnNames={"Id","Emri_Punëtorit","Kompania","Pozita","Paga","Data"};
    private List<Kontrata>data;
    
    public KontrataTableModel()
    {
    }
    public KontrataTableModel(List<Kontrata>data)
    {
        this.data=data;
    }
    public void add(List<Kontrata>data)
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
    public Kontrata getKontrata(int index){
           return data.get(index);
    }
    public String getDate (Date date){
        DateFormat da = new SimpleDateFormat("dd/MM/yyyy");
        
        return da.format(date);
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kontrata k=(Kontrata)data.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                return k.getKontrataId();
            case 1:
                return k.getEmri();
            case 2:
                return k.getKompania();
            case 3:
                return k.getPozita();
            case 4:
                return k.getPaga();
            case 5:
                return getDate(k.getData());
            default:
                return null;
        }
    }
    
}
