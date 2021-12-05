/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userInterface.Student;

import userInterface.Teacher.*;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author 83715
 */
public class ManageStudent extends javax.swing.JPanel {

    JPanel rightPanel;
    
    /**
     * Creates new form manageTeacher
     */
    public ManageStudent(JPanel rp) {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        StudentTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        tbnVacancies = new javax.swing.JButton();
        tbnEnrollStudent = new javax.swing.JButton();
        tbnView1 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(650, 400));
        setPreferredSize(new java.awt.Dimension(650, 400));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        StudentTable.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        StudentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "FirstName", "LastName", "Age", "Gender", "RegisteredDate"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(StudentTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 600, 190));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Manage Student ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 80, -1));

        tbnVacancies.setBackground(new java.awt.Color(255, 255, 255));
        tbnVacancies.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tbnVacancies.setText("View Records");
        tbnVacancies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnVacanciesActionPerformed(evt);
            }
        });
        add(tbnVacancies, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, 110, -1));

        tbnEnrollStudent.setBackground(new java.awt.Color(255, 255, 255));
        tbnEnrollStudent.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tbnEnrollStudent.setText("Enroll Stuent");
        tbnEnrollStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnEnrollStudentActionPerformed(evt);
            }
        });
        add(tbnEnrollStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 110, -1));

        tbnView1.setBackground(new java.awt.Color(255, 255, 255));
        tbnView1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tbnView1.setText("View Detail");
        tbnView1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnView1ActionPerformed(evt);
            }
        });
        add(tbnView1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 110, -1));

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Update >1 year");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tbnVacanciesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnVacanciesActionPerformed
        // TODO add your handling code here:
        ViewStudentRecord etp = new ViewStudentRecord(rightPanel);
        rightPanel.removeAll();
        rightPanel.add("viewStudentRecordJPanel",etp);
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.last(rightPanel);
    }//GEN-LAST:event_tbnVacanciesActionPerformed

    private void tbnEnrollStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnEnrollStudentActionPerformed
        // TODO add your handling code here:
        EnrollStudent esp = new EnrollStudent(rightPanel);
        rightPanel.removeAll();
        rightPanel.add("enrollStudentJPanel",esp);
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.last(rightPanel);
    }//GEN-LAST:event_tbnEnrollStudentActionPerformed

    private void tbnView1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnView1ActionPerformed
        // TODO add your handling code here:
        ViewStudent etp = new ViewStudent(rightPanel);
        rightPanel.removeAll();
        rightPanel.add("viewStudentJPanel",etp);
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.last(rightPanel);
    }//GEN-LAST:event_tbnView1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable StudentTable;
    private javax.swing.JButton btnDelete;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton tbnEnrollStudent;
    private javax.swing.JButton tbnVacancies;
    private javax.swing.JButton tbnView1;
    // End of variables declaration//GEN-END:variables
}
