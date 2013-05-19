package GUI;

import DAO.ParcDAO;
import Metier.Parc;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class MyTableParc extends AbstractTableModel
{

    private String[] colHeader = {"Matricule","Etat","Disponible"};
    private Object[][] rows = refresh();

    
    

    public Object[][] refresh() 
    {
        ArrayList<Parc> l = ParcDAO.getInstance().listAll();
        Object[][] tab = new Object[l.size()][3];
        int i = 0;
        for(Parc p : l)
        {
            tab[i][0] = p.getMat();
            tab[i][1] = p.getEtat();
            if(p.isDispo())
            {
                tab[i][2] = "Disponible";
            }
            else
            {
                tab[i][2] = "Non Disponible";
            }
            i++;
        }
        return tab;
    }
    
    
    
    public Object getValueAt(int arg0, int arg1) {
        return rows[arg0][arg1];
    }
 
    public void setHeader(String[] newHeaders) {
        colHeader = newHeaders;
        super.fireTableStructureChanged();
    }
 
    public int getColumnCount() {
        return this.colHeader.length;
    }
 
    public String getColumnName(int column) {
        return this.colHeader[column];
    }
 
    public int getRowCount() {
        return this.rows.length;
    }
 
    
    public String[] getColumnHeader() {
        return colHeader;
    }
    
    public void setData(Object[][] newData) {
        rows = newData;
        super.fireTableDataChanged();
    }
    
}