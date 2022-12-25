/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trAndpl.gui;

import trAndpl.Dao.QuestionDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import trAndpl.Dao.JobDAO;
import trAndpl.pojo.QuesPojo;

/**
 *
 * @author Dell
 */
public class HrSetQuizFrame extends javax.swing.JFrame {

    private int Counter=0;
    private List<QuesPojo> questionList=new ArrayList<>();
    private String jobId;
    public HrSetQuizFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        lblQno.setText(String.valueOf(Counter+1));
     }
    public HrSetQuizFrame(String jobId){
         this();
         this.jobId=jobId;
    }
    private boolean validateInput(){
        if(TxtQues.getText().trim().isEmpty()||TxtOpt1.getText().trim().isEmpty()||TxtOpt2.getText().trim().isEmpty()||TxtOpt3.getText().trim().isEmpty()||TxtOpt4.getText().trim().isEmpty()||jcCorrectOpt.getSelectedIndex()==0)         
            return false;
        return true;
    }
    private void ClearText(){
        TxtQues.setText("");
        TxtOpt1.setText("");
        TxtOpt2.setText("");
        TxtOpt3.setText("");
        TxtOpt4.setText("");
        jcCorrectOpt.setSelectedIndex(0);
        TxtQues.requestFocus();
    }
    private QuesPojo SetQuestion(){
        QuesPojo question=new QuesPojo();
        
        question.setJobId(jobId);
        question.setQno(Counter+1);
        question.setQuestion(TxtQues.getText().trim());
        question.setOption1(TxtOpt1.getText().trim());
        question.setOption2(TxtOpt2.getText().trim());
        question.setOption3(TxtOpt3.getText().trim());
        question.setOption4(TxtOpt4.getText().trim());
        question.setCorrectOption(jcCorrectOpt.getSelectedIndex());    
        
        return question;
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
        BtnDiscard = new javax.swing.JButton();
        BtnNext = new javax.swing.JButton();
        BtnPrev = new javax.swing.JButton();
        BtnSubmit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jcCorrectOpt = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TxtOpt2 = new javax.swing.JTextField();
        TxtOpt4 = new javax.swing.JTextField();
        TxtOpt1 = new javax.swing.JTextField();
        TxtOpt3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtQues = new javax.swing.JTextArea();
        lblQno = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(243, 245, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trAndpl/Images/transparent logo.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trAndpl/Images/World-Map.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 960, 210));

        BtnDiscard.setBackground(new java.awt.Color(204, 204, 255));
        BtnDiscard.setText("Discard Paper");
        BtnDiscard.setOpaque(false);
        BtnDiscard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDiscardActionPerformed(evt);
            }
        });
        jPanel1.add(BtnDiscard, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 660, 130, -1));

        BtnNext.setBackground(new java.awt.Color(204, 204, 255));
        BtnNext.setText("Next");
        BtnNext.setOpaque(false);
        BtnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNextActionPerformed(evt);
            }
        });
        jPanel1.add(BtnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 660, 120, -1));

        BtnPrev.setBackground(new java.awt.Color(204, 204, 255));
        BtnPrev.setText("Previous");
        BtnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrevActionPerformed(evt);
            }
        });
        jPanel1.add(BtnPrev, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 660, 110, -1));

        BtnSubmit.setBackground(new java.awt.Color(204, 204, 255));
        BtnSubmit.setText("Submit");
        BtnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSubmitActionPerformed(evt);
            }
        });
        jPanel1.add(BtnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 660, 120, -1));

        jLabel2.setFont(new java.awt.Font("Noteworthy", 1, 24)); // NOI18N
        jLabel2.setText("Correct Options-");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 550, -1, -1));

        jcCorrectOpt.setBackground(new java.awt.Color(204, 204, 255));
        jcCorrectOpt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose Options", "Option1", "Option2", "Option3", "Option4" }));
        jPanel1.add(jcCorrectOpt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 560, 290, 30));

        jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 610, 960, 10));

        jLabel6.setFont(new java.awt.Font("Noteworthy", 1, 24)); // NOI18N
        jLabel6.setText("Options-");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        jLabel7.setFont(new java.awt.Font("Noteworthy", 1, 12)); // NOI18N
        jLabel7.setText("Option 1");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 400, 60, -1));

        TxtOpt2.setBackground(new java.awt.Color(173, 192, 234));
        TxtOpt2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        TxtOpt2.setBorder(null);
        TxtOpt2.setOpaque(false);
        jPanel1.add(TxtOpt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 400, 280, 20));

        TxtOpt4.setBackground(new java.awt.Color(173, 192, 234));
        TxtOpt4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        TxtOpt4.setBorder(null);
        TxtOpt4.setOpaque(false);
        jPanel1.add(TxtOpt4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 470, 280, 20));

        TxtOpt1.setBackground(new java.awt.Color(173, 192, 234));
        TxtOpt1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        TxtOpt1.setBorder(null);
        TxtOpt1.setOpaque(false);
        jPanel1.add(TxtOpt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 270, 20));

        TxtOpt3.setBackground(new java.awt.Color(173, 192, 234));
        TxtOpt3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        TxtOpt3.setBorder(null);
        TxtOpt3.setOpaque(false);
        jPanel1.add(TxtOpt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, 280, 20));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trAndpl/Images/2021-12-23 00.04.59.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, -1, -1));

        jLabel10.setFont(new java.awt.Font("Noteworthy", 1, 12)); // NOI18N
        jLabel10.setText("Option 3");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 470, 60, -1));

        jLabel11.setFont(new java.awt.Font("Noteworthy", 1, 12)); // NOI18N
        jLabel11.setText("Option 4");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, 60, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trAndpl/Images/2021-12-23 00.04.59.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 460, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trAndpl/Images/2021-12-23 00.04.59.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, -1, -1));

        jLabel14.setFont(new java.awt.Font("Noteworthy", 1, 12)); // NOI18N
        jLabel14.setText("Option 2");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 400, 60, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trAndpl/Images/2021-12-23 00.04.59.png"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 390, -1, -1));

        jLabel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 960, 150));

        jLabel3.setFont(new java.awt.Font("Noteworthy", 1, 24)); // NOI18N
        jLabel3.setText("Que.");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        TxtQues.setBackground(new java.awt.Color(173, 192, 234));
        TxtQues.setColumns(20);
        TxtQues.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TxtQues.setRows(5);
        jScrollPane1.setViewportView(TxtQues);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 850, 80));

        lblQno.setFont(new java.awt.Font("Noteworthy", 1, 18)); // NOI18N
        jPanel1.add(lblQno, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 226, 30, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1036, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnDiscardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDiscardActionPerformed
        int ans;
        ans= JOptionPane.showConfirmDialog(null, "Are You Sure Discard the Test?", "Discard!", JOptionPane.YES_NO_OPTION);
        if(ans==JOptionPane.YES_OPTION){
           new HrOptionsFrame().setVisible(true);
           this.dispose();
        }
    }//GEN-LAST:event_BtnDiscardActionPerformed
    private void getQuestionFromList(){
        QuesPojo question;
        question=questionList.get(Counter);
        TxtQues.setText(question.getQuestion());
        TxtOpt1.setText(question.getOption1());
        TxtOpt2.setText(question.getOption2());
        TxtOpt3.setText(question.getOption3());
        TxtOpt4.setText(question.getOption4());
        jcCorrectOpt.setSelectedIndex(question.getCorrectOption());
    }
    private void BtnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNextActionPerformed
       if(validateInput()){
           QuesPojo question=SetQuestion();
           if(Counter==questionList.size()){
               questionList.add(question);
               ClearText();
               ++Counter;
           }else{
               questionList.set(Counter, question);
               ++Counter;
               if(Counter==questionList.size())
                   ClearText();
               else
                   getQuestionFromList();
           }
            lblQno.setText(String.valueOf(Counter+1));
       }
       else{
           JOptionPane.showMessageDialog(null,"Please Fill all the Fields", "Empty Question!!", JOptionPane.WARNING_MESSAGE);
       }
    }//GEN-LAST:event_BtnNextActionPerformed

    private void BtnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrevActionPerformed
        if(Counter==0)
            return;
        
        if(Counter==questionList.size()){
            if(validateInput()){
                int result=JOptionPane.showConfirmDialog(null, "You have an unsaved question. Do you want to save it", "Confirm!", JOptionPane.YES_NO_OPTION);
                if(result==JOptionPane.YES_OPTION){
                    QuesPojo question=SetQuestion();
                    ClearText();      
                }
            }
            --Counter;
            getQuestionFromList();
        }else{
            if(validateInput()){
                QuesPojo question=SetQuestion();
                questionList.set(Counter, question);
                --Counter;
                 getQuestionFromList();
            }
           else{
            JOptionPane.showMessageDialog(null,"Please Fill all the Fields", "Empty Question!!", JOptionPane.WARNING_MESSAGE);
            }
          }
         lblQno.setText(String.valueOf(Counter+1));
    }//GEN-LAST:event_BtnPrevActionPerformed

    private void BtnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSubmitActionPerformed
       if(validateInput()){
           QuesPojo que=SetQuestion();
           if(Counter==questionList.size()){
               questionList.add(que);
           }else{
               questionList.set(Counter, que);
           }
           try{
               boolean result=QuestionDAO.setPaper(questionList);
               if(result){
                   JOptionPane.showMessageDialog(null, "Question Paper Added Succesfully!","Success",JOptionPane.INFORMATION_MESSAGE);
                   JobDAO.setJobStatus(jobId);
                   new HrQuizOptionsFrame().setVisible(true);
                   this.dispose();
               }else{
                   JOptionPane.showMessageDialog(null, "Could Not Add the Paper","Failure!", JOptionPane.WARNING_MESSAGE);
               }
           } 
            catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Db Error","Error in DB Communication !", JOptionPane.ERROR_MESSAGE);   
            ex.printStackTrace();
          }
      }
        else{
            JOptionPane.showMessageDialog(null,"Please Fill all the Fields", "Empty Question!!", JOptionPane.WARNING_MESSAGE);
          }
    
           
       
    }//GEN-LAST:event_BtnSubmitActionPerformed

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
            java.util.logging.Logger.getLogger(HrSetQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HrSetQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HrSetQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HrSetQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HrSetQuizFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDiscard;
    private javax.swing.JButton BtnNext;
    private javax.swing.JButton BtnPrev;
    private javax.swing.JButton BtnSubmit;
    private javax.swing.JTextField TxtOpt1;
    private javax.swing.JTextField TxtOpt2;
    private javax.swing.JTextField TxtOpt3;
    private javax.swing.JTextField TxtOpt4;
    private javax.swing.JTextArea TxtQues;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcCorrectOpt;
    private javax.swing.JLabel lblQno;
    // End of variables declaration//GEN-END:variables
}
