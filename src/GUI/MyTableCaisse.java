package GUI;

import DAO.EntreCaisseDAO;
import Metier.EntreCaisse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class MyTableCaisse extends AbstractTableModel
{

    private String[] colHeader = {"Type","Description","Agent","Montant","Date"};
    private Object[][] rows = refresh();

    public Object[][] refresh() 
    {
        ArrayList<EntreCaisse> l = EntreCaisseDAO.getInstance().listall();
        Object[][] tab = new Object[l.size()][5];
        int i = 0;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        for(EntreCaisse e : l)
        {
            tab[i][0] = e.getType();
            tab[i][1] = e.getDescription();
            tab[i][2] = e.getAgent().getNom()+" "+e.getAgent().getPrenom();
            tab[i][3] = e.getMontant();
            tab[i][4] = df.format(e.getDate());
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