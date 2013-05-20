package GUI;

import DAO.GeoDAO;
import java.awt.image.ImageObserver;
import javax.swing.JFrame;
import Technique.GoogleGeoCode;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.imageio.ImageIO;

public class FLocateVoiture extends JFrame implements ImageObserver
{
    String location;
    String mat;
    String[] cor;
    Image img;
    public FLocateVoiture(String mat)
    {
        this.mat=mat;
        location = GeoDAO.getInstance().locate(mat);
        getlocation();
        initGUI();
    }

    private void initGUI() 
    {
        this.setTitle("Localisation de "+mat);
        this.setSize(600,400);
        this.setLocation(30,30);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
    }

    private void getlocation() 
    {
        String response = GoogleGeoCode.getLocation(location);
        cor = GoogleGeoCode.parseLocation(response);
        String lat = cor[0];
        String lon = cor[1];
        String url = "http://maps.googleapis.com/maps/api/staticmap?center="+
                Double.parseDouble(lat)+","+
                Double.parseDouble(lon)+
                "&zoom=14&size=590x390&markers=color:red%7Clabel:S%7C"+Double.parseDouble(lat)+
                ","+Double.parseDouble(lon)+"&sensor=false";
        try
        {
            img = ImageIO.read(new URL(url));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void paint(Graphics g)
    {
        g.drawImage(img,0,0, this);
    }
}