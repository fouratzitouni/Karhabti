package GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.net.URL;
import javax.swing.JPanel;

public class PBanner extends JPanel implements ImageObserver
{
    Image img;
    public PBanner()
    {
        URL url = getClass().getResource("/img/logo.png");
        img = Toolkit.getDefaultToolkit().getImage(url);
    }
    public void paint(Graphics g)
    {
        g.drawImage(img,0,0, this);
    }
}