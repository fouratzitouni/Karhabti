package DAO;

import Metier.Agent;
import Metier.Chauffeur;
import Metier.Client;
import Metier.Contrat;
import Metier.Voiture;
import Technique.DbCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Technique.Authentification;
import java.sql.Date;
import java.util.ArrayList;


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
    
    public boolean insert(Contrat c)
    {
        boolean t = false;
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

                pst.setInt(4,c.getChauffeur()); 

            pst.setInt(5,Authentification.getInstance().getAgent().getId());
            pst.setDate(6,c.getDebut());
            pst.setDate(7,c.getFin());
            t = !pst.execute();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return t;
    }
    
    public ArrayList<Contrat> listAll()
    {
        ArrayList<Contrat> l = new ArrayList<Contrat>();
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("SELECT * FROM contrat;");
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                Client c1 = ClientDAO.getInstance().findbycin(res.getString(3));
                Voiture v = VoitureDAO.getInstance().find(res.getString(2));
                Agent a = AgentDAO.getInstance().findbyid(res.getInt(6));
                Date debut = res.getDate(7);
                Date Fin = res.getDate(8);
                Contrat c = new Contrat(debut, Fin, a, c1, v);
                if(res.getString(4) != null)
                {
                    c.setClient2(ClientDAO.getInstance().findbycin(res.getString(4)));
                }
                if(res.getInt(5) != 0)
                {
                    c.setChauffeur(res.getInt(5));
                }
                l.add(c);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return l;
    }
    
    public boolean delete(String mat, String cin, Date debut)
    {
        boolean t = false;
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("DELETE FROM contrat WHERE mat = ? AND client1 = ? AND debut = ? ;");
            pst.setString(1, mat);
            pst.setString(2, cin);
            pst.setDate(3, debut);
            t = !pst.execute();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return t;
    }
    
    public Contrat find(String mat, String cin, Date debut)
    {
        Contrat c = null;
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("Select * FROM contrat WHERE mat = ? AND client1 = ? AND debut = ? ;");
            pst.setString(1, mat);
            pst.setString(2, cin);
            pst.setDate(3, debut);
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                Agent a = AgentDAO.getInstance().findbyid(res.getInt(6));
                Voiture v = VoitureDAO.getInstance().find(res.getString(2));
                Client c1 = ClientDAO.getInstance().findbycin(res.getString(3));
                Client c2 = null;
                if(res.getString(4) != null)
                {
                    c2 = ClientDAO.getInstance().findbycin(res.getString(3));
                }
                int ch = 0;
                if(res.getInt(5) != 0)
                {
                    ch = res.getInt(5);
                }
                c = new Contrat(debut, debut, a, c1, v);
                c.setClient2(c2);
                c.setChauffeur(ch);
                
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return c;
    }
}