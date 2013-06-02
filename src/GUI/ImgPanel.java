package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.io.FileNotFoundException;
import java.net.URL;
import javax.swing.JPanel;


public class ImgPanel extends JPanel implements ImageObserver
{
    Image bgImg;
    public ImgPanel(String location)
    {
        //URL imgURL = getClass().getResource(location);

        bgImg = Toolkit.getDefaultToolkit().createImage(location);
        this.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

    }
    
        public void paint(Graphics g)
        {
            g.setColor(Color.WHITE);
            g.drawRect(0,0,310,310);
            g.drawImage(bgImg, 0, 0, this);
        }
}