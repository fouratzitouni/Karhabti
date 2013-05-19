package GUI;

import DAO.AgentDAO;
import Metier.Agent;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class MyTableAgents extends AbstractTableModel
{

    private String[] colHeader = {"Nom","Prenom","Tel"};
    private Object[][] rows = refresh();

    public Object[][] refresh() 
    {
        ArrayList<Agent> l = AgentDAO.getInstance().listAll();
        Object[][] tab = new Object[l.size()][3];
        int i = 0;
        for(Agent a : l)
        {
            tab[i][0] = a.getNom();
            tab[i][1] = a.getPrenom();
            tab[i][2] = a.getTel();
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