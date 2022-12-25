/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trAndpl.gui;

/**
 *
 * @author Dell
 */
public class HrQuizOptionsFrame extends javax.swing.JFrame {

    /**
     * Creates new form HrQuizOptionsFrame
     */
    public HrQuizOptionsFrame() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BtnLogout = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        BtnEditQuiz = new javax.swing.JButton();
        BtnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BtnAddQuiz = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(243, 245, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trAndpl/Images/transparent logo.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trAndpl/Images/World-Map.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 55, 967, 216));

        jLabel3.setFont(new java.awt.Font("Monotype Corsiva", 1, 24)); // NOI18N
        jLabel3.setText("Welcome ,");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        BtnLogout.setBackground(new java.awt.Color(204, 204, 255));
        BtnLogout.setText("Logout");
        BtnLogout.setOpaque(false);
        BtnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLogoutActionPerformed(evt);
            }
        });
        jPanel1.add(BtnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 600, 120, -1));

        lblName.setFont(new java.awt.Font("Monotype Corsiva", 1, 24)); // NOI18N
        lblName.setText("Swapnil");
        jPanel1.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 164, -1));

        BtnEditQuiz.setBackground(new java.awt.Color(204, 204, 255));
        BtnEditQuiz.setText("Edit Quiz");
        BtnEditQuiz.setOpaque(false);
        BtnEditQuiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditQuizActionPerformed(evt);
            }
        });
        jPanel1.add(BtnEditQuiz, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 530, 140, 30));

        BtnBack.setBackground(new java.awt.Color(204, 204, 255));
        BtnBack.setText("Back");
        BtnBack.setOpaque(false);
        BtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBackActionPerformed(evt);
            }
        });
        jPanel1.add(BtnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 600, 110, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trAndpl/Images/istockphoto-1285196602-612x612.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 215, 174));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trAndpl/Images/new/setQuiz.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 231, 186));

        BtnAddQuiz.setBackground(new java.awt.Color(204, 204, 255));
        BtnAddQuiz.setText("Add Quiz");
        BtnAddQuiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddQuizActionPerformed(evt);
            }
        });
        jPanel1.add(BtnAddQuiz, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 540, 140, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1011, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLogoutActionPerformed
        new LoginFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnLogoutActionPerformed

    private void BtnEditQuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditQuizActionPerformed
        new HrChooseJobEditingQuizFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnEditQuizActionPerformed

    private void BtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBackActionPerformed
        new HrJobOptionsFrame().setVisible(true);
        this.dispose();;
    }//GEN-LAST:event_BtnBackActionPerformed

    private void BtnAddQuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddQuizActionPerformed
       new HrChooseJobForSettingQuizFrame().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_BtnAddQuizActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HrQuizOptionsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HrQuizOptionsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HrQuizOptionsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HrQuizOptionsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HrQuizOptionsFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAddQuiz;
    private javax.swing.JButton BtnBack;
    private javax.swing.JButton BtnEditQuiz;
    private javax.swing.JButton BtnLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblName;
    // End of variables declaration//GEN-END:variables
}
