package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame
{
    JPanel cards;
    PSidebar sidebar = new PSidebar(this);
    JPanel peast = new JPanel(new BorderLayout());
    PAfficheParc pparc = new PAfficheParc();
    PAfficheVoiture pvoiture = new PAfficheVoiture();
    PAfficheContrats pcontrat = new PAfficheContrats();
    PAfficheClients pclient = new PAfficheClients();
    PAfficheAgentsChaffeurs pagent = new PAfficheAgentsChaffeurs();
    PAfficheComptabilite pcompta = new PAfficheComptabilite();
    
    public void addComponentsToPane(Container pane)
    {
        cards = new JPanel(new CardLayout());
        cards.add(pparc,"Parc");
        cards.add(pvoiture,"Voitures");
        cards.add(pcontrat,"Contrats");
        cards.add(pclient,"Clients");
        cards.add(pagent,"Agents/Chauffeurs");
        cards.add(pcompta,"Comptabilite");
        peast.add(cards,BorderLayout.SOUTH);
        pane.add(sidebar,BorderLayout.WEST);
        pane.add(peast,BorderLayout.CENTER);
        //CardLayout cl = (CardLayout)
    }
    
    public JPanel getCards()
    {
        return cards;
    }
    public void initGUI()
    {
        this.setLayout(new BorderLayout());
        this.addComponentsToPane(this.getContentPane());
        this.setSize(800,500);
        this.setLocation(30,60);
        this.setTitle("Karhabti: Location de Voiture");
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    
    public MainFrame(){ initGUI(); }
    public static void main(String[] args)
    {
        JFrame fauth = new JFrame("Authentification");
        fauth.add(new PAuthentification(fauth));
        fauth.setDefaultCloseOperation(EXIT_ON_CLOSE);
        fauth.setSize(410,310);
        fauth.setLocation(500,100);
        fauth.setResizable(false);
        fauth.setVisible(true);
    }
}