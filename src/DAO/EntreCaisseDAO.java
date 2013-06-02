package DAO;


import Metier.Agent;
import Metier.EntreCaisse;
import Technique.DbCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public final class EntreCaisseDAO
{
    private static EntreCaisseDAO ins;
    
    private Connection getConnection(){ return DbCon.getInstance().getConnection();}
    private EntreCaisseDAO(){}
    
    public static synchronized EntreCaisseDAO getInstance()
    {
        if(ins == null)
        {
            ins = new EntreCaisseDAO();
        }
        return ins;
    }
    
    public ArrayList<EntreCaisse> listall()
    {
        ArrayList<EntreCaisse> l = new ArrayList<EntreCaisse>();
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("SELECT * FROM caisse;");
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                Agent a = AgentDAO.getInstance().findbyid(res.getInt(4));
                EntreCaisse ec = new EntreCaisse(res.getString(2),res.getString(5), res.getString(3),a);
                ec.setDate(res.getDate(6));
                l.add(ec);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return l;
    }
    
}