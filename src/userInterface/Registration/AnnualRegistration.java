/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userInterface.Registration;

import userInterface.Student.*;
import userInterface.Teacher.*;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author 83715
 */
public class AnnualRegistration extends javax.swing.JPanel {

    JPanel rightPanel;
    
    /**
     * Creates new form manageTeacher
     */
    public AnnualRegistration(JPanel rp) {
        initComponents();     
        rightPanel = rp;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        btnStudentCheck = new javax.swing.JButton();
        btnTeacherCheck = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(650, 400));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel7.setText("Annual Registration Check");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, -1, -1));

        btnStudentCheck.setBackground(new java.awt.Color(255, 255, 255));
        btnStudentCheck.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnStudentCheck.setText("Student");
        btnStudentCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentCheckActionPerformed(evt);
            }
        });
        add(btnStudentCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, -1, -1));

        btnTeacherCheck.setBackground(new java.awt.Color(255, 255, 255));
        btnTeacherCheck.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnTeacherCheck.setText("Teacher");
        btnTeacherCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeacherCheckActionPerformed(evt);
            }
        });
        add(btnTeacherCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnTeacherCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeacherCheckActionPerformed
        // TODO add your handling code here:
        TeacherAnnualRegistration etp = new TeacherAnnualRegistration(rightPanel);
        rightPanel.removeAll();
        rightPanel.add("TeacherAnnualRegistrationJPanel",etp);
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.last(rightPanel);
    }//GEN-LAST:event_btnTeacherCheckActionPerformed

    private void btnStudentCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentCheckActionPerformed
        // TODO add your handling code here:
        StudentAnnualRegistration etp = new StudentAnnualRegistration(rightPanel);
        rightPanel.removeAll();
        rightPanel.add("StudentAnnualRegistrationJPanel",etp);
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.last(rightPanel);
    }//GEN-LAST:event_btnStudentCheckActionPerformed

    private void backAction(){
        rightPanel.remove(this);
        Component[] componentArray = rightPanel.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ManageStudent msjp = (ManageStudent) component;
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.previous(rightPanel);        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStudentCheck;
    private javax.swing.JButton btnTeacherCheck;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
