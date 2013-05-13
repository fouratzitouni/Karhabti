package DAO;

import Technique.Authentification;
import Technique.DbCon;
import Metier.Agent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class AuthentificationDAO
{
    private static AuthentificationDAO ins;
    
    private Connection getConnection(){ return DbCon.getInstance().getConnection();}
    private AuthentificationDAO(){}
    
    public static synchronized AuthentificationDAO getInstance()
    {
        if(ins == null)
        {
            ins = new AuthentificationDAO();
        }
        return ins;
    }
    
    public Agent connect(String login, String pass)
    {
        Agent a = null;
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("SELECT * FROM agent WHERE login = ? AND pass = ?");
            pst.setString(1,login);
            pst.setString(2,pass);
            ResultSet res = pst.executeQuery();
            if(res.next())
            {
                a = new Agent(res.getString(2),res.getString(3),res.getString(4),res.getString(6));
                a.setId(res.getInt(1));
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return a;
    }
            
}