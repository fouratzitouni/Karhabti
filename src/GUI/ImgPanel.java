package GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.net.URL;
import javax.swing.JPanel;


public class ImgPanel extends JPanel implements ImageObserver
{
    Image bgImg;
    public ImgPanel(String location)
    {
        URL imgURL = getClass().getResource(location);

        bgImg = Toolkit.getDefaultToolkit().getImage(imgURL);
    }
    
        public void paint(Graphics g)
        {
        g.drawImage(bgImg, 0, 0, this);
        }
}