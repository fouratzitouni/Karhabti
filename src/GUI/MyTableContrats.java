package GUI;

import DAO.ContratDAO;
import Metier.Contrat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class MyTableContrats extends AbstractTableModel
{

    private String[] colHeader = {"Matricule","Client","Debut","Fin","Agent"};
    private Object[][] rows = refresh();

    public Object[][] refresh() 
    {
        ArrayList<Contrat> l = ContratDAO.getInstance().listAll();
        Object[][] tab = new Object[l.size()][5];
        
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        int i = 0;
        for(Contrat c : l)
        {
            tab[i][0] = c.getV().getMat();
            tab[i][1] = c.getClient1().getNom()+" "+c.getClient1().getPrenom();
            tab[i][2] = df.format(c.getDebut());
            tab[i][3] = df.format(c.getFin());
            tab[i][4] = c.getAgent().getNom()+" "+c.getAgent().getPrenom();
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