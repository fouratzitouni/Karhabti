
package GUI;

import DAO.VoitureDAO;
import Metier.Voiture;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class PAfficheVoiture extends javax.swing.JPanel {

    static MyTableVoitures tm = new MyTableVoitures();
    
    public PAfficheVoiture() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListeVoiture = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        TFMarque = new javax.swing.JTextField();
        jButtonRecherche = new javax.swing.JButton();
        jButtonModifier = new javax.swing.JButton();
        jButtonVendre = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(400, 500));
        setMinimumSize(new java.awt.Dimension(400, 500));

        jTableListeVoiture.setModel(this.tm);
        jTableListeVoiture.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListeVoitureMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableListeVoiture);

        jLabel1.setText("Marque");

        jButtonRecherche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        jButtonRecherche.setText("Rechercher");
        jButtonRecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRechercheActionPerformed(evt);
            }
        });

        jButtonModifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        jButtonModifier.setText("Modifier");
        jButtonModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifierActionPerformed(evt);
            }
        });

        jButtonVendre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arrow 1.png"))); // NOI18N
        jButtonVendre.setText("Vendre");
        jButtonVendre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVendreActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
        jButton1.setText("Ajouter Nouvelle");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(TFMarque)
                .addGap(18, 18, 18)
                .addComponent(jButtonRecherche)
                .addGap(44, 44, 44))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButtonModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonVendre, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TFMarque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRecherche))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVendre, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(152, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRechercheActionPerformed
        if(!TFMarque.getText().isEmpty())
        {
            String marque = TFMarque.getText();
            tm.setData(tm.refresh(VoitureDAO.getInstance().search(marque)));
        }
        else 
        {
            tm.setData(tm.refresh());
        }
    }//GEN-LAST:event_jButtonRechercheActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFrame f = new JFrame("Ajouter une Voiture");
        f.setSize(600,500);
        f.add(new PAjoutVoiture(f,this,0,null));
        f.setAlwaysOnTop(true);
        f.setResizable(false);
        f.setLocation(20,20);
        f.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifierActionPerformed
        if(jTableListeVoiture.getSelectedRow() != -1)
        {
            Voiture v = VoitureDAO.getInstance().find(String.valueOf(tm.getValueAt(jTableListeVoiture.getSelectedRow(),0)));
            JFrame f = new JFrame("Modifier une Voiture");
            f.setSize(600,500);
            PAjoutVoiture p = new PAjoutVoiture(f,this,2,v);
            f.add(p);
            f.setAlwaysOnTop(true);
            f.setResizable(false);
            f.setLocation(20,20);
            f.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Pas de voiture selectionnee","Erreur",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonModifierActionPerformed

    private void jButtonVendreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVendreActionPerformed
        if(jTableListeVoiture.getSelectedRow() != -1)
        {
            String v = String.valueOf(tm.getValueAt(jTableListeVoiture.getSelectedRow(),0));
            JFrame f = new JFrame("Modifier une Voiture");
            
            f.setSize(600,500);
            this.add(new PVendreVoiture(v, f));
            f.setAlwaysOnTop(true);
            f.setResizable(false);
            f.setLocation(20,20);
            f.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Pas de voiture selectionnee","Erreur",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonVendreActionPerformed

    private void jTableListeVoitureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListeVoitureMouseClicked
        if(evt.getClickCount() == 2 && !evt.isConsumed())
        {
            Voiture v = VoitureDAO.getInstance().find(String.valueOf(tm.getValueAt(jTableListeVoiture.getSelectedRow(),0)));
            JFrame f = new JFrame("Fiche de Voiture "+v.getMat());
            f.setSize(600,500);
            f.add(new PViewVoiture(v,f));
            f.setAlwaysOnTop(true);
            f.setResizable(false);
            f.setLocation(20,20);
            f.setVisible(true);
        }
    }//GEN-LAST:event_jTableListeVoitureMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TFMarque;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonModifier;
    private javax.swing.JButton jButtonRecherche;
    private javax.swing.JButton jButtonVendre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListeVoiture;
    // End of variables declaration//GEN-END:variables

}
