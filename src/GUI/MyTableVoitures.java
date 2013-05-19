package GUI;

import DAO.VoitureDAO;
import Metier.Voiture;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class MyTableVoitures extends AbstractTableModel
{

    private String[] colHeader = {"Matricule","Marque","Modele","Couleur","Tarif"};
    private Object[][] rows = refresh();
    

    public Object[][] refresh() 
    {
        ArrayList<Voiture> l = VoitureDAO.getInstance().listAll();
        System.out.println(l.size());
        Object[][] tab = new Object[l.size()][5];
        int i = 0;
        for(Voiture v : l)
        {
            tab[i][0] = v.getMat();
            tab[i][1] = v.getMarque();
            tab[i][2] = v.getModel();
            tab[i][3] = v.getCouleur();
            tab[i][4] = v.getTarif();
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