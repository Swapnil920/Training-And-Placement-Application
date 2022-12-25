/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trAndpl.gui;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import trAndpl.Dao.JobDAO;
import trAndpl.Dao.UserDAO;
import trAndpl.pojo.CurrentUser;
import trAndpl.pojo.JobPojo;

/**
 *
 * @author Dell
 */
public class HrRemoveJobFrame extends javax.swing.JFrame {
    DefaultTableModel model;
    public HrRemoveJobFrame() {
        initComponents();
        setLocationRelativeTo(null);
        lblName.setText(CurrentUser.getName());
        model=(DefaultTableModel)tbleAllJobs.getModel();
        LoadJobDetails();
    }
    
    private void LoadJobDetails(){
        try{
            List<JobPojo> allJobsList=JobDAO.getAllActiveJobsByCurrent(CurrentUser.getId());
            for(JobPojo job:allJobsList){
                Vector<String> row=new Vector<>();
                row.add(job.getJobId());
                row.add(job.getJobTitle());
                row.add(job.getTags());
                row.add(String.valueOf(job.getStatus()));
                model.addRow(row);
            }
            if(allJobsList.isEmpty()){
                JOptionPane.showMessageDialog(null,"No Job Present","Job Not Present", JOptionPane.INFORMATION_MESSAGE);
            }
          }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Db Error","Error!", JOptionPane.ERROR_MESSAGE);   
            ex.printStackTrace();
            
        }
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
        BtnBack = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbleAllJobs = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        BtnRemoveJob = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(243, 245, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trAndpl/Images/transparent logo.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trAndpl/Images/World-Map.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 980, 200));

        jLabel3.setFont(new java.awt.Font("Noteworthy", 1, 18)); // NOI18N
        jLabel3.setText("Welcome ,");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 240, 80, 30));

        BtnLogout.setBackground(new java.awt.Color(204, 204, 255));
        BtnLogout.setText("Logout");
        BtnLogout.setOpaque(false);
        BtnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLogoutActionPerformed(evt);
            }
        });
        jPanel1.add(BtnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 650, 149, -1));

        lblName.setFont(new java.awt.Font("Noteworthy", 1, 18)); // NOI18N
        lblName.setText("Swapnil");
        jPanel1.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 190, 30));

        BtnBack.setBackground(new java.awt.Color(204, 204, 255));
        BtnBack.setText("Back");
        BtnBack.setOpaque(false);
        BtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBackActionPerformed(evt);
            }
        });
        jPanel1.add(BtnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 650, 130, -1));

        jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 1000, 20));

        tbleAllJobs.setBackground(new java.awt.Color(204, 204, 255));
        tbleAllJobs.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tbleAllJobs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job-Id", "Job Title", "Skills", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbleAllJobs.setOpaque(false);
        jScrollPane1.setViewportView(tbleAllJobs);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 710, 240));

        jLabel5.setFont(new java.awt.Font("Noteworthy", 1, 18)); // NOI18N
        jLabel5.setText("All Job's");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 70, 20));

        BtnRemoveJob.setBackground(new java.awt.Color(204, 204, 255));
        BtnRemoveJob.setText("Remove JOB");
        BtnRemoveJob.setOpaque(false);
        BtnRemoveJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRemoveJobActionPerformed(evt);
            }
        });
        jPanel1.add(BtnRemoveJob, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 640, 250, 39));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trAndpl/Images/new/removeJob.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 200, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 999, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLogoutActionPerformed
        new LoginFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnLogoutActionPerformed

    private void BtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBackActionPerformed
        new HrJobOptionsFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnBackActionPerformed

    private void BtnRemoveJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRemoveJobActionPerformed
        int row=tbleAllJobs.getSelectedRow();
        if(row==-1){
            JOptionPane.showMessageDialog(null, "Please select a row first");
            return;
        }
        String jobId=(String)tbleAllJobs.getValueAt(row, 0);
        int resp=JOptionPane.showConfirmDialog(null, "Are you sure, you want to remove "+jobId+"?","Delete",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE);
        if(resp==JOptionPane.OK_OPTION){
            try{
                String UserId=(String)tbleAllJobs.getValueAt(row,1);
                boolean result=JobDAO.removejobsbyjobId(jobId);
                if(result){
                   model.removeRow(row);
                   JOptionPane.showMessageDialog(null, "Job Deleted!", "Success",JOptionPane.INFORMATION_MESSAGE);
                    if(model.getRowCount()==0){
                        BtnRemoveJob.setEnabled(false);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Job Not DELETED!", "Deletion Unsuccesful!",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Db Error","Error!", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();

            }
        }

    }//GEN-LAST:event_BtnRemoveJobActionPerformed

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
            java.util.logging.Logger.getLogger(HrRemoveJobFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HrRemoveJobFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HrRemoveJobFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HrRemoveJobFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HrRemoveJobFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBack;
    private javax.swing.JButton BtnLogout;
    private javax.swing.JButton BtnRemoveJob;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblName;
    private javax.swing.JTable tbleAllJobs;
    // End of variables declaration//GEN-END:variables
}
