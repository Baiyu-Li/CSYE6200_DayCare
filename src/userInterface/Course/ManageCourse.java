/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userInterface.Course;

import Controller.MainController;
import Controller.SqliteController;
import userInterface.Teacher.*;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userInterface.Immunization.ViewStudentImmunization;
import userInterface.Student.ManageStudent;
import userInterface.MainFrame;

/**
 *
 * @author 83715
 */
public class ManageCourse extends javax.swing.JPanel {

    JPanel container;
    
    /**
     * Creates new form manageTeacher
     */
    private CardLayout clayout;

    public ManageCourse(JPanel container) {        
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
        CourseTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        tbnView = new javax.swing.JButton();
        tbnEnrollCour = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(650, 400));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        CourseTable.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        CourseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Time", "Loaction", "Instructor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(CourseTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, 190));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Manage Course");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 80, -1));

        tbnView.setBackground(new java.awt.Color(255, 255, 255));
        tbnView.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tbnView.setText("View Detail");
        tbnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnViewActionPerformed(evt);
            }
        });
        add(tbnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, 110, -1));

        tbnEnrollCour.setBackground(new java.awt.Color(255, 255, 255));
        tbnEnrollCour.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tbnEnrollCour.setText("Create Course");
        tbnEnrollCour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnEnrollCourActionPerformed(evt);
            }
        });
        add(tbnEnrollCour, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 130, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tbnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnViewActionPerformed
        // TODO add your handling code here:
        ((ViewCourse)this.container.getComponent(5)).setTable(SqliteController.getAllTeacher());
        clayout.show(container, "viewCourseJPanel");
    }//GEN-LAST:event_tbnViewActionPerformed

    private void tbnEnrollCourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnEnrollCourActionPerformed
        // TODO add your handling code here:
        //((EnrollCourse)this.container.getComponent(15)).setTable(SqliteController.getAllTeacher());
        clayout.show(container, "enrollCourseJPanel");
    }//GEN-LAST:event_tbnEnrollCourActionPerformed

    //import value from database
    public void setTable(List<Object[]> ol){
        DefaultTableModel tableModel=(DefaultTableModel) CourseTable.getModel();
        tableModel.setColumnIdentifiers(new Object[]{"ID", "Name", "Time", "Location", "Instructor"}); 
        ol.forEach((e)-> {tableModel.addRow(e);});
       CourseTable.setModel(tableModel);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CourseTable;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton tbnEnrollCour;
    private javax.swing.JButton tbnView;
    // End of variables declaration//GEN-END:variables
}