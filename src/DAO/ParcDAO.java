package DAO;

import Metier.Parc;
import Technique.DbCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public final class ParcDAO
{
    private static ParcDAO ins;
    
    private Connection getConnection(){ return DbCon.getInstance().getConnection();}
    private ParcDAO(){}
    
    public static synchronized ParcDAO getInstance()
    {
        if(ins == null)
        {
            ins = new ParcDAO();
        }
        return ins;
    }
    
    public ArrayList<Parc> listAll()
    {
        ArrayList<Parc> l = new ArrayList<Parc>();
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("SELECT * FROM parc;");
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                Parc p = new Parc(res.getString(1),res.getString(3),(res.getInt(2) == 1));
                l.add(p);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return l;
    }
    
}
