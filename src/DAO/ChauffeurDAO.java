package DAO;

import Technique.DbCon;
import java.sql.Connection;
import Metier.Chauffeur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


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
    
    public boolean insert(Chauffeur c)
    {
        boolean t = false;
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
            t= !pst.execute();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return t;
    }
    
    public int getId(String nom)
    {
        int id = 1;
        String n = nom.substring(0,nom.indexOf(" "));
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("SELECT * FROM chauffeur WHERE nom = ?;");
            pst.setString(1,n);
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
    
    public Chauffeur findbyid(int id)
    {
        Chauffeur c = null;
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("SELECT * FROM chauffeur WHERE id = ?;");
            pst.setInt(1,id);
            ResultSet res = pst.executeQuery();
            if(res.next())
            {
                c = new Chauffeur(res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getFloat(7));
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return c;
    }
    
    public ArrayList<Chauffeur> listAll()
    {
        ArrayList<Chauffeur> l = new ArrayList<Chauffeur>();
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("SELECT * FROM chauffeur;");
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                Chauffeur c = new Chauffeur(res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getFloat(7));
                l.add(c);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return l;
    }
    
    public boolean delete(String l)
    {
        boolean t = false;
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("DELETE FROM chauffeur WHERE tel = ?;");
            pst.setString(1, l);
            t = !pst.execute();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return t;
    }
}