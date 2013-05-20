/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.VoitureDAO;
import Metier.Voiture;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Fourat
 */
public class PAfficheParc extends javax.swing.JPanel {

    MyTableParc tm = new MyTableParc();
    public PAfficheParc() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonLouer = new javax.swing.JButton();
        jButtonLocaliser = new javax.swing.JButton();
        jButtonReparer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        jButtonLouer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tick 1.png"))); // NOI18N
        jButtonLouer.setText("Louer");
        jButtonLouer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLouerActionPerformed(evt);
            }
        });

        jButtonLocaliser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/location 2.png"))); // NOI18N
        jButtonLocaliser.setText("Localiser");
        jButtonLocaliser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLocaliserActionPerformed(evt);
            }
        });

        jButtonReparer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tool.png"))); // NOI18N
        jButtonReparer.setText("Reparer");

        jTable1.setModel(this.tm);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("Etat du Parc");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jButtonLouer, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonLocaliser, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonReparer, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLouer, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLocaliser, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonReparer, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLouerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLouerActionPerformed
        if(jTable1.getSelectedRow() != -1)
        {
            String dispo = String.valueOf(tm.getValueAt(jTable1.getSelectedRow(),2));
            if(dispo.equals("Disponible"))
            {
                Voiture v = VoitureDAO.getInstance().find(String.valueOf(tm.getValueAt(jTable1.getSelectedRow(),0)));
                JFrame f = new JFrame("Louer une Voiture");
                f.setSize(600,500);
                f.add(new PLouer(f,v,this));
                f.setAlwaysOnTop(true);
                f.setResizable(false);
                f.setLocation(20,20);
                f.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Voiture non disponible","Erreur",JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Pas de voiture selectionnee","Erreur",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonLouerActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if(evt.getClickCount() == 2 && !evt.isConsumed())
        {
            Voiture v = VoitureDAO.getInstance().find(String.valueOf(tm.getValueAt(jTable1.getSelectedRow(),0)));
            JFrame f = new JFrame("Fiche de Voiture "+v.getMat());
            f.setSize(600,500);
            f.add(new PViewVoiture(v,f));
            f.setAlwaysOnTop(true);
            f.setResizable(false);
            f.setLocation(20,20);
            f.setVisible(true);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButtonLocaliserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLocaliserActionPerformed
        if(jTable1.getSelectedRow() != -1)
        {
            String mat = String.valueOf(tm.getValueAt(jTable1.getSelectedRow(),0));
            new FLocateVoiture(mat);
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Pas de voiture selectionnee","Erreur",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonLocaliserActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLocaliser;
    private javax.swing.JButton jButtonLouer;
    private javax.swing.JButton jButtonReparer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
