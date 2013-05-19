package DAO;

import Metier.Assurance;
import Technique.DbCon;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public final class AssuranceDAO
{
    private static AssuranceDAO ins;
    
    private Connection getConnection(){ return DbCon.getInstance().getConnection();}
    private AssuranceDAO(){}
    
    public static synchronized AssuranceDAO getInstance()
    {
        if(ins == null)
        {
            ins = new AssuranceDAO();
        }
        return ins;
    }
    
    public boolean insert(Assurance a)
    {
        boolean t = false;
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("INSERT INTO assurance VALUES(?,?,?,?);");
            pst.setString(1,a.getNumero());
            pst.setDate(2,a.getDebut());
            pst.setDate(3,a.getFin());
            pst.setFloat(4,a.getPrix());
            t = !pst.execute();
            System.out.println(t);
        }catch (SQLException ex){System.out.println(ex.getMessage());}
        return t;
    }
    
    public Assurance fetch(String num)
    {
        Assurance a = null;
        try
        {
            PreparedStatement pst = getConnection().prepareStatement("SELECT * FROM assurance WHERE numero = ?;");
            pst.setString(1,num);
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                a = new Assurance(res.getString(1),res.getDate(2),res.getDate(3),res.getFloat(4));
            }
        }catch (SQLException ex){System.out.println(ex.getMessage());}
        return a;
    }
}