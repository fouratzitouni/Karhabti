package GUI;

import DAO.ChauffeurDAO;
import Metier.Chauffeur;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class MyTableChauffeurs extends AbstractTableModel
{

    private String[] colHeader = {"Nom","Prenom","Tel","Prix"};
    private Object[][] rows = refresh();

    public Object[][] refresh() 
    {
        ArrayList<Chauffeur> l = ChauffeurDAO.getInstance().listAll();
        Object[][] tab = new Object[l.size()][4];
        int i = 0;
        for(Chauffeur a : l)
        {
            tab[i][0] = a.getNom();
            tab[i][1] = a.getPrenom();
            tab[i][2] = a.getTel();
            tab[i][3] = a.getPrix();
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