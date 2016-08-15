/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.TableModel;

import Ejb.Punetori;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Drilon
 */
public class PunetoriTableModel extends AbstractTableModel{
    private String [] columnNames={"P_id","Emri","Mbiemri","Adresa","Qyteti","Telefoni","Departamenti","Shfrytezuesi","Kontrata"};
    private List<Punetori>data;
    public PunetoriTableModel()
    {}
    
    public PunetoriTableModel(List<Punetori>data)
    {
        this.data=data;
    }
     public void add(List<Punetori>data)
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
    public Punetori getPunetori(int index){
           return data.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Punetori p=(Punetori)data.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                return p.getPid();
            case 1:
                return p.getEmri();
            case 2:
                return p.getMbiemri();
            case 3:
                return p.getAdresa();
            case 4:
                return p.getQyteti();
            case 5:
                return p.getTelefoni();
            case 6:
                return p.getDid();
            case 7:
                return p.getUid();
            case 8:
                return p.getKontrataid();
            default:
                return null;
        }
    }
    
}
