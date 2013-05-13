package DAO;

import Metier.Contrat;
import Technique.DbCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Technique.Authentification;

public final class ContratDAO
{
    private static ContratDAO ins;
    
    private Connection getConnection(){ return DbCon.getInstance().getConnection();}
    private ContratDAO(){}
    
    public static synchronized ContratDAO getInstance()
    {
        if(ins == null)
        {
            ins = new ContratDAO();
        }
        return ins;
    }
    
    public void insert(Contrat c)
    {
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("INSERT INTO contrat VALUES (default,?,?,?,?,?,?,?);");
            pst.setString(1,c.getV().getMat());
            pst.setString(2,c.getClient1().getCin());
            if(c.getClient2() != null)
            {
                pst.setString(3,c.getClient2().getCin());
            }
            else
            {
                pst.setString(3,null);
            }
            if(c.getChauffeur() != null)
            {
                pst.setInt(4,ChauffeurDAO.getInstance().getId(c.getChauffeur())); // chauffeur DAO
            }
            else
            {
                pst.setString(4, null);
            }
            pst.setInt(5,Authentification.getInstance().getAgent().getId()); 
            pst.setString(6,c.getDebut());
            pst.setString(7,c.getFin());
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}