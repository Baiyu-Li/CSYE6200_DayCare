/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userInterface.Course;

import Controller.SqliteController;
import userInterface.Teacher.*;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 83715
 */
public class ViewCourse extends javax.swing.JPanel {

    JPanel container;
    
    /**
     * Creates new form manageTeacher
     */
    
    private CardLayout clayout;
    
    public ViewCourse(JPanel container) {
        initComponents();     
        this.container = container;
        SqliteController.test();
        clayout = (CardLayout) container.getLayout();  
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
        enrolledStudentTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnBack6 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(650, 400));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        enrolledStudentTable.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        enrolledStudentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "FirstName", "LastName", "Subject"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(enrolledStudentTable);
        if (enrolledStudentTable.getColumnModel().getColumnCount() > 0) {
            enrolledStudentTable.getColumnModel().getColumn(3).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, 190));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Student Enrolled");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, -1));

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, 80, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("ID");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, -1, -1));

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 40, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("Course Details");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        btnBack6.setBackground(new java.awt.Color(255, 255, 255));
        btnBack6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnBack6.setText("<< Back");
        btnBack6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack6ActionPerformed(evt);
            }
        });
        add(btnBack6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void btnBack6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack6ActionPerformed
        // TODO add your handling code here:
        ((ManageCourse)this.container.getComponent(4)).setTable(SqliteController.getAllTeacher());
        clayout.show(container, "courseManage");
    }//GEN-LAST:event_btnBack6ActionPerformed

    public void setTable(List<Object[]> ol){
        DefaultTableModel tableModel=(DefaultTableModel) enrolledStudentTable.getModel();
        tableModel.setColumnIdentifiers(new Object[]{"ID", "FirstName", "LastName", "Subject"}); 
        ol.forEach((e)-> {tableModel.addRow(e);});
       enrolledStudentTable.setModel(tableModel);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnBack2;
    private javax.swing.JButton btnBack3;
    private javax.swing.JButton btnBack4;
    private javax.swing.JButton btnBack5;
    private javax.swing.JButton btnBack6;
    private javax.swing.JButton btnDelete;
    private javax.swing.JTable enrolledStudentTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
