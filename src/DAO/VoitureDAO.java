package DAO;

import Metier.Assurance;
import Metier.Voiture;
import Technique.DbCon;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public final class VoitureDAO
{
    private static VoitureDAO ins;
    
    private Connection getConnection(){ return DbCon.getInstance().getConnection();}
    private VoitureDAO(){}
    
    public static synchronized VoitureDAO getInstance()
    {
        if(ins == null)
        {
            ins = new VoitureDAO();
        }
        return ins;
    }
    
    public boolean insert(Voiture v)
    {
        boolean t = false;
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("INSERT INTO Voiture VALUES"
                    + " (?,?,?,?,?,?,?,?,?,?);");
            pst.setString(1,v.getMat());
            pst.setString(2,v.getMarque());
            pst.setString(3,v.getModel());
            pst.setString(4,v.getCarburant());
            pst.setString(5,v.getPuiss());
            pst.setString(6,v.getCouleur());
            pst.setString(7,v.getPolice().getNumero());
            pst.setFloat(8,v.getTarif());
            pst.setFloat(9,v.getCaution());
            if(v.getImage() != null)
            {
                pst.setBinaryStream(10,new FileInputStream(v.getImage()),v.getImage().length());
            }
            else
            {
                pst.setBinaryStream(10,null,0);
            }
            t = !pst.execute();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return t;
    }
    
    public void delete(String mat)
    {
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("DELETE FROM voiture WHERE mat = ?;");
            pst.setString(1, mat);
            pst.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public ArrayList<Voiture> listAll()
    {
        ArrayList<Voiture> l = new ArrayList<Voiture>();
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("SELECT * FROM voiture;");
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                String mat = res.getString(1);
                String marque = res.getString(2);
                String model = res.getString(3);
                String carb = res.getString(4);
                String puiss = res.getString(5);
                String coul = res.getString(6);
                float tarif = res.getFloat(8);
                float caution = res.getFloat(9);
                String numpolice = res.getString(7);
                PreparedStatement stt = getConnection().prepareStatement("SELECT * FROM assurance WHERE numero = ?;");
                stt.setString(1,numpolice);
                ResultSet r = stt.executeQuery();
                Date debut = null, fin = null;
                float prix = 0;
                while(r.next())
                {
                    debut = r.getDate(2);
                    fin = r.getDate(3);
                    prix = r.getFloat(4);
                }
                File img = null;
                if(res.getBinaryStream(10) != null)
                {
                    img = new File(getFilePath(mat));
                    FileOutputStream ostreamImage = new FileOutputStream(img);
                    InputStream istreamImage = res.getBinaryStream(10);
                    byte[] buffer = new byte[1024];
                    int length = 0;
	
                    while((length = istreamImage.read(buffer)) != -1)
                    {
                        ostreamImage.write(buffer, 0, length);
                    }
                }
                Assurance a = new Assurance(numpolice, debut, fin, prix);
                Voiture v = new Voiture(mat, marque, model, carb, puiss, coul, a, tarif, caution, null);
                l.add(v);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
           System.out.println(ex.getMessage());
        }
        return l;
    }
    
    public Voiture find(String matr)
    {
        Voiture v = null;
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("SELECT * FROM voiture WHERE mat = ?;");
            pst.setString(1, matr);
            ResultSet res = pst.executeQuery();
            if(res.next())
            {
                String mat = res.getString(1);
                String marque = res.getString(2);
                String model = res.getString(3);
                String carb = res.getString(4);
                String puiss = res.getString(5);
                String coul = res.getString(6);
                float tarif = res.getFloat(8);
                float caution = res.getFloat(9);
                String numpolice = res.getString(7);
                PreparedStatement stt = getConnection().prepareStatement("SELECT * FROM assurance WHERE numero = ?;");
                stt.setString(1,numpolice);
                ResultSet r = stt.executeQuery();
                Date debut = null, fin = null;
                float prix = 0;
                while(r.next())
                {
                    debut = r.getDate(2);
                    fin = r.getDate(3);
                    prix = r.getFloat(4);
                }
                File img = null;
                if(res.getBinaryStream(10) != null)
                {
                    img = new File(getFilePath(mat));
                    FileOutputStream ostreamImage = new FileOutputStream(img);
                    InputStream istreamImage = res.getBinaryStream(10);
                    byte[] buffer = new byte[1024];
                    int length = 0;
	
                    while((length = istreamImage.read(buffer)) != -1)
                    {
                        ostreamImage.write(buffer, 0, length);
                    }
                }
                Assurance a = new Assurance(numpolice, debut, fin, prix);
                v = new Voiture(mat, marque, model, carb, puiss, coul, a, tarif, caution,img);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return v;
    }
    
    public String getFilePath(String t)
    {
        return "C:\\Users\\Fourat\\Documents\\Karhabti\\"+t+".jpg";
    }
    
    public boolean edit(Voiture v)
    {
        boolean t = false;
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("UPDATE Voiture SET"
                    + "marque = ?, model = ?, carburant = ?, puiss = ?, couleur = ?, police = ?, tarif = ?,"
                    + " caution = ?, image = ?"
                    + "WHERE mat = ?;");
            pst.setString(10,v.getMat());
            pst.setString(1,v.getMarque());
            pst.setString(2,v.getModel());
            pst.setString(3,v.getCarburant());
            pst.setString(4,v.getPuiss());
            pst.setString(5,v.getCouleur());
            pst.setString(6,v.getPolice().getNumero());
            pst.setFloat(7,v.getTarif());
            pst.setFloat(8,v.getCaution());
            if(v.getImage() != null)
            {
                pst.setBinaryStream(9,new FileInputStream(v.getImage()),v.getImage().length());
            }
            else
            {
                pst.setBinaryStream(9,null,0);
            }
            t = !pst.execute();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return t;
    }
}