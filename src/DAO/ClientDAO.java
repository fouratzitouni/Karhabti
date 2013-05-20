package DAO;

import Technique.DbCon;
import Metier.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public final class ClientDAO
{
    private static ClientDAO ins;
    
    private Connection getConnection(){ return DbCon.getInstance().getConnection();}
    private ClientDAO(){}
    
    public static synchronized ClientDAO getInstance()
    {
        if(ins == null)
        {
            ins = new ClientDAO();
        }
        return ins;
    }
    
    public boolean insert(Client c)
    {
        boolean t = false;
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("INSERT INTO client VALUES(?,?,?,?,?,?,?,?);");
            pst.setString(1,c.getCin());
            pst.setString(2,c.getPermi());
            pst.setString(3,c.getNom());
            pst.setString(4,c.getPrenom());
            pst.setString(5,c.getAdr());
            if(c.getEmail() != null)
            {
                pst.setString(6,c.getEmail());
            }
            else
            {
                pst.setString(6,null);
            }
            pst.setString(7,c.getTel());
            pst.setString(8,c.getCat());
            t= !pst.execute();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return t;
    }
    
    public Client find(String nom)
    {
        Client c = null;
        String n = nom.substring(0,nom.indexOf(" "));
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("SELECT * FROM client WHERE nom = ?;");
            pst.setString(1, n);
            ResultSet res = pst.executeQuery();
            if(res.next())
            {
                c = new Client(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(7),res.getString(8));
                if(res.getString(6) != null)
                {
                    c.setEmail(res.getString(6));
                }
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return c;
    }
    
    public Client findbycin(String cin)
    {
        Client c = null;
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("SELECT * FROM client WHERE cin = ?;");
            pst.setString(1,cin);
            ResultSet res = pst.executeQuery();
            if(res.next())
            {
                c = new Client(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(7),res.getString(8));
                if(res.getString(6) != null)
                {
                    c.setEmail(res.getString(6));
                }
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return c;
    }
    
    public ArrayList<Client> listAll()
    {
        ArrayList<Client> l = new ArrayList<Client>();
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("SELECT * FROM client;");
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                Client c = new Client(res.getString(1),res.getString(2),res.getString(3),res.getString(4),
                        res.getString(5),res.getString(7),res.getString(8));
                if(res.getString(6) != null)
                {
                    c.setEmail(res.getString(6));
                }
                l.add(c);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return l;
    }
    
    public boolean edit(Client c)
    {
        boolean t = false;
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("UPDATE client SET "
                    + "permis = ?, nom = ?, prenom = ?, adr = ?, email = ?, tel = ?, cat = ?"
                    + " WHERE cin = ?");
            pst.setString(8,c.getCin());
            pst.setString(1,c.getPermi());
            pst.setString(2,c.getNom());
            pst.setString(3,c.getPrenom());
            pst.setString(4,c.getAdr());
            if(c.getEmail() != null)
            {
                pst.setString(5,c.getEmail());
            }
            else
            {
                pst.setString(5,null);
            }
            pst.setString(6,c.getTel());
            pst.setString(7,c.getCat());
            t= !pst.execute();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return t;
    }
    
    public boolean delete(String cin)
    {
        boolean t = false;
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("DELETE FROM client WHERE cin = ? ;");
            pst.setString(1,cin);
            t= !pst.execute();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return t;
    }
}