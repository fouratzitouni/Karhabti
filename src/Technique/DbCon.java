package Technique;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public final class DbCon 
{
    //static String driver;
    static XmlDataBase dbProp = new XmlDataBase();
    static Connection con;
    static Statement st;
    static DbCon sing;
    
    private DbCon()
    {
        try
        {
            //Class.forName(driver);
            String url = "jdbc:mysql://"+dbProp.getServer()+"/"+dbProp.getDB();
            con = DriverManager.getConnection(url,dbProp.getUser(),dbProp.getPwd());
        }catch(SQLException e){System.out.println(e.getMessage());}
    }
    
    public static synchronized DbCon getInstance()
    {
        if(sing == null)
        {
            sing = new DbCon();
        }
        return sing;
    }
    
    public Connection getConnection(){return con;}
}
