
package GUI;

import DAO.AssuranceDAO;
import DAO.VoitureDAO;
import Metier.Assurance;
import Metier.Voiture;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Amine
 */
public class PAjoutVoiture extends javax.swing.JPanel {

    File img = null;
    JFrame f;
    PAfficheVoiture p;
    Voiture v;
    int m;
    public PAjoutVoiture(JFrame f,PAfficheVoiture p, int m, Voiture v) {
        this.f=f;
        this.p=p;
        this.v=v;
        this.m=m;
        initComponents();
        if(m == 2)
        {
            jLabel1.setText("Modifier une Voiture");
            this.TFMatricule.setText(v.getMat());
            this.TFMarque.setText(v.getMarque());
            this.TFModele.setText(v.getModel());
            this.TFPuissance.setText(v.getPuiss());
            this.TFCouleur.setText(v.getCouleur());
            this.TFCaution.setText(String.valueOf(v.getCaution()));
            this.jComboBox1.setSelectedItem((Object)v.getCarburant());
            this.TFAssurance.setText(v.getPolice().getNumero());
            this.TFTarif.setText(String.valueOf(v.getTarif()));
            if(v.getImage() != null)
            {
                this.TFImage.setText(v.getImage().getAbsolutePath());
            }
        }
    }

    public JTextField getTFAssurance() {
        return TFAssurance;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TFMatricule = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TFMarque = new javax.swing.JTextField();
        TFModele = new javax.swing.JTextField();
        TFPuissance = new javax.swing.JTextField();
        TFCouleur = new javax.swing.JTextField();
        TFAssurance = new javax.swing.JTextField();
        TFTarif = new javax.swing.JTextField();
        TFCaution = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        TFImage = new javax.swing.JTextField();
        jButtonParcourir = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));

        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Matricule");

        TFMatricule.setMinimumSize(new java.awt.Dimension(15, 20));
        TFMatricule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFMatriculeActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Marque");

        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Modele");

        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Puissance");

        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("Type du carburant");

        jLabel6.setForeground(new java.awt.Color(0, 0, 153));
        jLabel6.setText("Couleur");

        jLabel7.setForeground(new java.awt.Color(0, 0, 153));
        jLabel7.setText("Assurance");

        jLabel8.setForeground(new java.awt.Color(0, 0, 153));
        jLabel8.setText("Tarif");

        jLabel9.setForeground(new java.awt.Color(0, 0, 153));
        jLabel9.setText("Caution");

        jLabel10.setForeground(new java.awt.Color(0, 0, 153));
        jLabel10.setText("Image");

        TFMarque.setMinimumSize(new java.awt.Dimension(15, 20));

        TFModele.setMinimumSize(new java.awt.Dimension(15, 20));

        TFPuissance.setMinimumSize(new java.awt.Dimension(15, 20));

        TFCouleur.setMinimumSize(new java.awt.Dimension(15, 20));

        TFAssurance.setEnabled(false);
        TFAssurance.setMinimumSize(new java.awt.Dimension(15, 20));
        TFAssurance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFAssuranceActionPerformed(evt);
            }
        });

        TFTarif.setMinimumSize(new java.awt.Dimension(15, 20));

        TFCaution.setMinimumSize(new java.awt.Dimension(15, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 255));
        jLabel11.setText("Ajouter une Voiture");

        TFImage.setEnabled(false);

        jButtonParcourir.setText("Parcourir");
        jButtonParcourir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonParcourirActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tick 1.png"))); // NOI18N
        jButton2.setText("Valider");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Essence", "Diesel", "GPL", "Electrique" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, 287, Short.MAX_VALUE)
                            .addComponent(TFImage, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFCaution, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TFTarif, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TFAssurance, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TFCouleur, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TFPuissance, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TFModele, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TFMarque, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TFMatricule, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonParcourir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(279, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TFMatricule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFMarque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFModele, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFPuissance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFCouleur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFAssurance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFTarif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFCaution, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(TFImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonParcourir))
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel10, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9});

    }// </editor-fold>//GEN-END:initComponents

    private void TFMatriculeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFMatriculeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFMatriculeActionPerformed

    private void TFAssuranceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFAssuranceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFAssuranceActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFrame f = new JFrame("Ajouter Assurance");
        f.add(new PAjoutAssurance(f,TFAssurance));
        f.setSize(500,500);
        f.setAlwaysOnTop(true);
        f.setResizable(false);
        f.setLocation(20,20);
        f.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonParcourirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonParcourirActionPerformed
        JFileChooser fs = new JFileChooser();
        fs.setDialogType(JFileChooser.OPEN_DIALOG);
        fs.setFileFilter(new ExtensionFileFilter("JPG,JPEG,PNG", new String[] { "JPG", "JPEG", "PNG" }));
        fs.showDialog(this,"Ouvrir une image");
        if(fs.getSelectedFile() != null)
        {
            img = fs.getSelectedFile();
            TFImage.setText(img.getAbsolutePath());
        }
    }//GEN-LAST:event_jButtonParcourirActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(!(TFMatricule.getText().isEmpty() && TFMarque.getText().isEmpty() 
                && TFModele.getText().isEmpty() && TFPuissance.getText().isEmpty() 
                && TFCouleur.getText().isEmpty() && (jComboBox1.getSelectedIndex() == -1)
                && TFAssurance.getText().isEmpty() && TFTarif.getText().isEmpty() 
                && TFCaution.getText().isEmpty()))
        {
            String mat = TFMatricule.getText();
            String marque = TFMarque.getText();
            String modele = TFModele.getText();
            String puiss = TFPuissance.getText();
            String carb = String.valueOf(jComboBox1.getSelectedItem());
            String coul = TFCouleur.getText();
            Assurance a = AssuranceDAO.getInstance().fetch(TFAssurance.getText());
            float tarif = Float.valueOf(TFTarif.getText());
            float causion = Float.valueOf(TFCaution.getText());
            Voiture v = new Voiture(mat, marque, modele, carb, puiss, coul, a, tarif, causion, img);
            if(this.m == 2)
            {
                if(VoitureDAO.getInstance().edit(v))
                {
                    JOptionPane.showMessageDialog(this,"Voiture Modifiee","Success",JOptionPane.INFORMATION_MESSAGE);
                    this.p.tm.setData(this.p.tm.refresh());
                    this.f.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Erreur de modification","Erreur",JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                if(VoitureDAO.getInstance().insert(v))
                {
                    JOptionPane.showMessageDialog(this,"Voiture Ajoutee","Success",JOptionPane.INFORMATION_MESSAGE);
                    this.p.tm.setData(this.p.tm.refresh());
                    this.f.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Erreur d'ajout","Erreur",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Erreur d'ajout","Erreur",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TFAssurance;
    private javax.swing.JTextField TFCaution;
    private javax.swing.JTextField TFCouleur;
    private javax.swing.JTextField TFImage;
    private javax.swing.JTextField TFMarque;
    private javax.swing.JTextField TFMatricule;
    private javax.swing.JTextField TFModele;
    private javax.swing.JTextField TFPuissance;
    private javax.swing.JTextField TFTarif;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonParcourir;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables

}
