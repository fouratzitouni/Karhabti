package DAO;

import Technique.DbCon;
import Metier.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    public void insert(Client c)
    {
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("INSERT INTO client VALUES(?,?,?,?,?,?,?,?);");
            pst.setString(1,c.getCin());
            pst.setString(2,c.getPermi());
            pst.setString(3,c.getNom());
            pst.setString(4,c.getPrenom());
            pst.setString(5,c.getAdr());
            pst.setString(6,c.getEmail());
            pst.setString(7,c.getTel());
            pst.setString(8,c.getCat());
            pst.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public Client find(String cin)
    {
        Client c = null;
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("SELECT * FROM client WHERE cin = ?;");
            pst.setString(1, cin);
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
    
    public List<Client> listAll()
    {
        List<Client> l = new ArrayList<Client>();
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("SELECT * FROM client;");
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                
                //l.add(v);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }/*catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }*/
        return l;
    }
}