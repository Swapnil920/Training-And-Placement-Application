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
import trAndpl.Dao.ResultDAO;
import trAndpl.pojo.CurrentUser;
import trAndpl.pojo.ParticipantJobPojo;
import trAndpl.pojo.ResultPojo;

/**
 *
 * @author Dell
 */
public class PtViewAllAvailableJobsFrame extends javax.swing.JFrame {

    private DefaultTableModel model;
    private List<ParticipantJobPojo> allOpenJobsList;
    public PtViewAllAvailableJobsFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        lblName.setText(CurrentUser.getName());
        model=(DefaultTableModel)tbleAllJobs.getModel();         
        loadOpenJobsDetails();

    }

    private void loadOpenJobsDetails(){
        try{
            allOpenJobsList=JobDAO.getAllAvailableJobs();
            for(ParticipantJobPojo job:allOpenJobsList){
                Vector<String> row=new Vector<>();
                row.add(job.getJobId());
                row.add(job.getJobTitle());
                row.add(job.getCompanyName());
                row.add(job.getTags());
                model.addRow(row);
            }
            if(allOpenJobsList.isEmpty()){
                JOptionPane.showMessageDialog(null,"No Jobs Available For Applying", "Job Not Found!",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"DB Error In Quiz", "Error!!",JOptionPane.ERROR_MESSAGE);
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
        BtnApplyForJobs = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(243, 245, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trAndpl/Images/transparent logo.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trAndpl/Images/World-Map.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 980, 200));

        jLabel3.setFont(new java.awt.Font("Noteworthy", 1, 18)); // NOI18N
        jLabel3.setText("Welcome ,");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 240, 80, 50));

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
        jPanel1.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 190, 30));

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
                "Job-Id", "Job Title", "Company Name", "Skills Required"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 710, 240));

        jLabel5.setFont(new java.awt.Font("Noteworthy", 1, 18)); // NOI18N
        jLabel5.setText("All Available Jobs:-");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 210, 30));

        BtnApplyForJobs.setBackground(new java.awt.Color(204, 204, 255));
        BtnApplyForJobs.setText("Apply For Jobs");
        BtnApplyForJobs.setOpaque(false);
        BtnApplyForJobs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnApplyForJobsActionPerformed(evt);
            }
        });
        jPanel1.add(BtnApplyForJobs, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 640, 250, 39));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trAndpl/Images/new/viewAllJob.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 231, 186));

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
           new ParticipantsOptionFrame().setVisible(true);
           this.dispose();
        
    }//GEN-LAST:event_BtnBackActionPerformed

    private void BtnApplyForJobsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnApplyForJobsActionPerformed
               
        int row=tbleAllJobs.getSelectedRow();
        if(row>-1)
        {
            try
            {  
                ResultPojo rs=new ResultPojo();
                rs.setpId(CurrentUser.getId());
                rs.setJobId((String)tbleAllJobs.getValueAt(row,0).toString().trim());
                rs.setPercentage(-1.0);
                if(ResultDAO.applyForJob(rs))
                {
                    JOptionPane.showMessageDialog(null,"Applied for Job successFully\n"
                            + "Now go to view all applied job and take Test !!!","Success...",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"You already applied for this job !!!","Warning",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
            catch(SQLException ex)
            {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"DB-Error While applied for job !!!","Error",JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Please select any row first !!!","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
             

       
             

    }//GEN-LAST:event_BtnApplyForJobsActionPerformed

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
            java.util.logging.Logger.getLogger(PtViewAllAvailableJobsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PtViewAllAvailableJobsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PtViewAllAvailableJobsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PtViewAllAvailableJobsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PtViewAllAvailableJobsFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnApplyForJobs;
    private javax.swing.JButton BtnBack;
    private javax.swing.JButton BtnLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblName;
    private javax.swing.JTable tbleAllJobs;
    // End of variables declaration//GEN-END:variables
}
