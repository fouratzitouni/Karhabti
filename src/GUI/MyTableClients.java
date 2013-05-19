package GUI;

import DAO.ClientDAO;
import Metier.Client;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class MyTableClients extends AbstractTableModel
{

    private String[] colHeader = {"Nom","Prenom","Cin","Telephone"};
    private Object[][] rows = refresh();

    public Object[][] refresh() 
    {
        ArrayList<Client> l = ClientDAO.getInstance().listAll();
        Object[][] tab = new Object[l.size()][4];
        int i = 0;
        for(Client c : l)
        {
            tab[i][0] = c.getNom();
            tab[i][1] = c.getPrenom();
            tab[i][2] = c.getCin();
            tab[i][3] = c.getTel();
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