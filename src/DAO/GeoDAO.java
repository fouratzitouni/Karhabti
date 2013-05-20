package DAO;

import Technique.DbCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public final class GeoDAO
{
    private static GeoDAO ins;
    
    private Connection getConnection(){ return DbCon.getInstance().getConnection();}
    private GeoDAO(){}
    
    public static synchronized GeoDAO getInstance()
    {
        if(ins == null)
        {
            ins = new GeoDAO();
        }
        return ins;
    }
    
    public String locate(String mat)
    {
        String t = "";
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("SELECT * FROM geo WHERE mat = ?");
            pst.setString(1, mat);
            ResultSet res = pst.executeQuery();
            if(res.next())
            {
                t = res.getString(2);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return t;
    }
    
}