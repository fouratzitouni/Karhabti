package Technique;


import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
public class XmlDataBase
{
    public static String filepath = "./config.xml";
    private String sv;
    private String user;
    private String pwd;
    private String db;
    
    public XmlDataBase()
    {
        try
        {
            File config = new File(filepath);
            DocumentBuilderFactory dbF = DocumentBuilderFactory.newInstance();
            DocumentBuilder docB = dbF.newDocumentBuilder();
            Document doc = docB.parse(config);
            doc.getDocumentElement().normalize();
            Node ndServer = doc.getElementsByTagName("server").item(0).getChildNodes().item(0);
            sv = ndServer.getNodeValue();
            Node ndUser = doc.getElementsByTagName("user").item(0).getChildNodes().item(0);
            user = ndUser.getNodeValue();
            Node ndPwd= doc.getElementsByTagName("pass").item(0).getChildNodes().item(0);
            pwd = ndPwd.getNodeValue();
            Node ndBd = doc.getElementsByTagName("db").item(0).getChildNodes().item(0);
            db = ndBd.getNodeValue();
        }catch(Exception e){System.out.println(e.getMessage());} 
    }
    
    public String getServer(){return sv;}
    public String getUser(){return user;}
    public String getPwd(){return pwd;}
    public String getDB(){return db;}
}