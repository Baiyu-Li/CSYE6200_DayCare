/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userInterface.Immunization;

import Controller.CourseController;
import userInterface.Student.*;
import Controller.SqliteController;
import userInterface.Teacher.*;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Floyed
 */
public class ManageStudentImmunization extends javax.swing.JPanel {

    JPanel container;
    
    /**
     * Creates new form manageTeacher
     */
    private CardLayout clayout;
    public ManageStudentImmunization(JPanel container) {
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
        StudentTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tbnView1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(650, 400));
        setPreferredSize(new java.awt.Dimension(650, 400));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jLabel1.setText("Manage Immunization records for students");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        tbnView1.setBackground(new java.awt.Color(255, 255, 255));
        tbnView1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tbnView1.setText("View/Manage vaccine information");
        tbnView1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnView1ActionPerformed(evt);
            }
        });
        add(tbnView1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 250, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void tbnView1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnView1ActionPerformed
        // TODO add your handling code here:
        //((ViewStudent)this.container.getComponent(7)).setTable(SqliteController.getAllTeacher());

        
        if(!StudentTable.getSelectionModel().isSelectionEmpty()){
            int row=StudentTable.getSelectedRow();
            Object o=StudentTable.getModel().getValueAt(row, 1);
            if(o !=null){
                int sid=Integer.parseInt(o.toString());
                String name=o.toString();

                ViewStudentImmunization vsi = new ViewStudentImmunization(container, name);

                clayout.show(container, "viewStudentImmunizationJPanel");
                
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please select a student");
        }
        
        
    }//GEN-LAST:event_tbnView1ActionPerformed
    
    //import value from database
    public void setTable(List<Object[]> ol){
        DefaultTableModel tableModel=(DefaultTableModel) StudentTable.getModel();
        tableModel.setColumnIdentifiers(new Object[]{"ID", "FirstName", "LastName", "Age", "Subject"}); 
        ol.forEach((e)-> {tableModel.addRow(e);});
       StudentTable.setModel(tableModel);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable StudentTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton tbnView1;
    // End of variables declaration//GEN-END:variables
}