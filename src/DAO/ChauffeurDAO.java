package DAO;

import Technique.DbCon;
import java.sql.Connection;
import Metier.Chauffeur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public final class ChauffeurDAO
{
    private static ChauffeurDAO ins;
    
    private Connection getConnection(){ return DbCon.getInstance().getConnection();}
    private ChauffeurDAO(){}
    
    public static synchronized ChauffeurDAO getInstance()
    {
        if(ins == null)
        {
            ins = new ChauffeurDAO();
        }
        return ins;
    }
    
    public void insert(Chauffeur c)
    {
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("INSERT INTO chauffeur VALUES(default,?,?,?,?,?,?);");
            pst.setString(1,c.getNom());
            pst.setString(2,c.getPrenom());
            pst.setString(3,c.getPermis());
            pst.setString(4,c.getTel());
            if(c.getEmail() != null)
            {
                pst.setString(5,c.getEmail());
            }
            else
            {
                pst.setString(5, null);
            }
            pst.setFloat(6,c.getPrix());
            pst.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public int getId(Chauffeur c)
    {
        int id =0;
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("SELECT * FROM chauffeur WHERE permis = ?;");
            pst.setString(1,c.getPermis());
            ResultSet res = pst.executeQuery();
            if(res.next())
            {
                id = res.getInt(1);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return id;
    }
}