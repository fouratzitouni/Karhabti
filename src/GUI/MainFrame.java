package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame
{
    PSidebar sidebar = new PSidebar();
    JPanel content = new JPanel(new BorderLayout());
    PAfficheParc pcon = new PAfficheParc();
    public void initGUI()
    {
        this.setLayout(new BorderLayout());
        this.add(sidebar,BorderLayout.WEST);
        content.add(pcon);
        this.add(content);
        this.setSize(800,500);
        this.setLocation(30,60);
        this.setTitle("Karhabti: Location de Voiture");
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public MainFrame(){ initGUI(); }
    public static void main(String[] args)
    {
        new MainFrame();
    }
}