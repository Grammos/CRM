/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.TableModel;

import Ejb.OpenLead;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Drilon
 */
public class OpenLeadTableModel extends AbstractTableModel
{
    private String [] columnNames={"Id","Emri","Mbiemri","Email","Telefoni","Statusi","Kompania","Shteti","Rruga","Qyteti","Zip code","Oferta"};
    private List<OpenLead>data;
    
    public OpenLeadTableModel()
    {}
    public OpenLeadTableModel(List<OpenLead>data)
    {
        this.data=data;
    }
    public void add(List<OpenLead>data)
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
    public OpenLead getLead(int index)
    {
        return data.get(index);
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        OpenLead o=(OpenLead)data.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                return o.getLeadid();
            case 1:
                return o.getEmri();
            case 2:
                return o.getMbiemri();
            case 3:
                return o.getEmail();
            case 4:
                return o.getTelefoni();
            case 5:
                return o.getLeadStatus();
            case 6:
                return o.getKompania();
            case 7:
                return o.getShteti();
            case 8:
                return o.getRruga();
            case 9:
                return o.getQyteti();
            case 10:
                return o.getZipCode();
            case 11:
                return o.getOfertaid();
            default:
                return null;
        }   
    }
    
}
