/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PAjoutClient.java
 *
 * Created on 13 mai 2013, 18:13:21
 */

package GUI;

/**
 *
 * @author Amine
 */
public class PAjoutClient extends javax.swing.JPanel {

    /** Creates new form PAjoutClient */
    public PAjoutClient() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TFNom = new javax.swing.JTextField();
        TFPrenom = new javax.swing.JTextField();
        TFCin = new javax.swing.JTextField();
        TFPermis = new javax.swing.JTextField();
        TFTel = new javax.swing.JTextField();
        TFMail = new javax.swing.JTextField();
        TFAdresse = new javax.swing.JTextField();
        TFCathegorie = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jButtonValider = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(400, 500));
        setMinimumSize(new java.awt.Dimension(400, 500));
        setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel2.setText("Nom");

        jLabel3.setText("Prénom");

        jLabel4.setText("CIN");

        jLabel5.setText("Permis");

        jLabel6.setText("Tel");

        jLabel7.setText("E-mail");

        jLabel8.setText("Adresse");

        jLabel9.setText("Catégorie");

        TFCathegorie.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Particulier", "Professionnel" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("Ajoutez un client");

        jButtonValider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tick 1.png"))); // NOI18N
        jButtonValider.setText("Ajouter");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 96, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonValider, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TFMail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFTel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFPermis, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFCin, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFPrenom, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFNom, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFAdresse)
                            .addComponent(TFCathegorie, javax.swing.GroupLayout.Alignment.LEADING, 0, 163, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TFNom))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TFPrenom))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TFCin))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TFPermis))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TFTel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TFMail))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TFAdresse))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(TFCathegorie))
                .addGap(18, 18, 18)
                .addComponent(jButtonValider, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TFAdresse;
    private javax.swing.JComboBox TFCathegorie;
    private javax.swing.JTextField TFCin;
    private javax.swing.JTextField TFMail;
    private javax.swing.JTextField TFNom;
    private javax.swing.JTextField TFPermis;
    private javax.swing.JTextField TFPrenom;
    private javax.swing.JTextField TFTel;
    private javax.swing.JButton jButtonValider;
    private javax.swing.JLabel jLabel1;
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
