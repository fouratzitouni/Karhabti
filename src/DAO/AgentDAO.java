package DAO;

import Metier.Agent;
import Technique.DbCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public final class AgentDAO
{
    private static AgentDAO ins;
    
    private Connection getConnection(){ return DbCon.getInstance().getConnection();}
    private AgentDAO(){}
    
    public static synchronized AgentDAO getInstance()
    {
        if(ins == null)
        {
            ins = new AgentDAO();
        }
        return ins;
    }
    
    public void insert(Agent a)
    {
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("INSERT INTO agent VALUES (default,?,?,?,?,?);");
            pst.setString(1,a.getNom());
            pst.setString(2,a.getPrenom());
            pst.setString(3,a.getLogin());
            pst.setString(4,a.getPass());
            pst.setString(5,a.getTel());
            pst.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public Agent find(String login)
    {
        Agent a = null;
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("SELECT * FROM agent WHERE login = ?;");
            pst.setString(1, login);
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
    
    public ArrayList<Agent> listAll()
    {
        ArrayList<Agent> l = new ArrayList<Agent>();
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("SELECT * FROM agent;");
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                Agent a = new Agent(res.getString(2),res.getString(3),res.getString(4),res.getString(6));
                l.add(a);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return l;
    }
    
}
