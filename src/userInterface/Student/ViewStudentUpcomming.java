/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userInterface.Student;

import Controller.SqliteController;
import userInterface.Teacher.*;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 83715
 */
public class ViewStudentUpcomming extends javax.swing.JPanel {

    JPanel container;
    
    /**
     * Creates new form manageTeacher
     */
    private CardLayout clayout;
    public ViewStudentUpcomming(JPanel container) {
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

        btnBack = new javax.swing.JButton();
        btnAddRecord = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtId1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        upcommingRecordTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pastRecordTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(650, 400));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, -1));

        btnAddRecord.setBackground(new java.awt.Color(255, 255, 255));
        btnAddRecord.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAddRecord.setText("Add New Record");
        btnAddRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRecordActionPerformed(evt);
            }
        });
        add(btnAddRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 140, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("ID");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel7.setText("Immunization Record");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 20, -1));

        txtId1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtId1ActionPerformed(evt);
            }
        });
        add(txtId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 80, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("Update Date");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, -1));

        upcommingRecordTable.setBackground(new java.awt.Color(156, 219, 155));
        upcommingRecordTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "VaccineName", "Dose", "Comming Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(upcommingRecordTable);
        if (upcommingRecordTable.getColumnModel().getColumnCount() > 0) {
            upcommingRecordTable.getColumnModel().getColumn(0).setResizable(false);
            upcommingRecordTable.getColumnModel().getColumn(1).setResizable(false);
            upcommingRecordTable.getColumnModel().getColumn(2).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, 100));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(156, 219, 155));
        jLabel2.setText("Upcomming");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        pastRecordTable.setBackground(new java.awt.Color(255, 102, 102));
        pastRecordTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "VaccineName", "Dose", "Past Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(pastRecordTable);
        if (pastRecordTable.getColumnModel().getColumnCount() > 0) {
            pastRecordTable.getColumnModel().getColumn(0).setResizable(false);
            pastRecordTable.getColumnModel().getColumn(1).setResizable(false);
            pastRecordTable.getColumnModel().getColumn(2).setResizable(false);
        }

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, -1, 100));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 102));
        jLabel3.setText("Past Due");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        ((ManageStudent)this.container.getComponent(2)).setTable(SqliteController.getAllTeacher());
        clayout.show(container, "studentManage");
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRecordActionPerformed
        // TODO add your handling code here:
        //((AddRecord)this.container.getComponent(12)).setTable(SqliteController.getAllTeacher());
        clayout.show(container, "addRecordJPanel");
    }//GEN-LAST:event_btnAddRecordActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtId1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtId1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtId1ActionPerformed

    public void setUpcommingTable(List<Object[]> ol){
        DefaultTableModel tableModel=(DefaultTableModel) upcommingRecordTable.getModel();
        tableModel.setColumnIdentifiers(new Object[]{"Name", "Does", "Date"}); 
        ol.forEach((e)-> {tableModel.addRow(e);});
       upcommingRecordTable.setModel(tableModel);
    }
    
    public void setPastTable(List<Object[]> ol){
        DefaultTableModel tableModel=(DefaultTableModel) pastRecordTable.getModel();
        tableModel.setColumnIdentifiers(new Object[]{"Name", "Does", "Date"}); 
        ol.forEach((e)-> {tableModel.addRow(e);});
       pastRecordTable.setModel(tableModel);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddRecord;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable pastRecordTable;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtId1;
    private javax.swing.JTable upcommingRecordTable;
    // End of variables declaration//GEN-END:variables
}
