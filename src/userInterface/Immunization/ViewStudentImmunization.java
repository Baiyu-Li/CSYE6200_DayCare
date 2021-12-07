/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userInterface.Immunization;

import userInterface.Student.*;
import userInterface.Teacher.*;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author 83715
 */
public class ViewStudentImmunization extends javax.swing.JPanel {

    JPanel rightPanel;
    
    /**
     * Creates new form manageTeacher
     */
    public ViewStudentImmunization(JPanel rp) {
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

        btnBack = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        RecordTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        RecordTable2 = new javax.swing.JTable();
        tbnView1 = new javax.swing.JButton();
        tbnVacancies = new javax.swing.JButton();

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

        jLabel7.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel7.setText("Immunization Reminder");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        RecordTable.setBackground(new java.awt.Color(255, 102, 102));
        RecordTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "StudentName", "VaccineName", "Dose", "Past Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
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
        jScrollPane1.setViewportView(RecordTable);
        if (RecordTable.getColumnModel().getColumnCount() > 0) {
            RecordTable.getColumnModel().getColumn(0).setResizable(false);
            RecordTable.getColumnModel().getColumn(1).setResizable(false);
            RecordTable.getColumnModel().getColumn(2).setResizable(false);
            RecordTable.getColumnModel().getColumn(3).setResizable(false);
            RecordTable.getColumnModel().getColumn(4).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 470, 100));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(156, 219, 155));
        jLabel2.setText("Upcomming");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 102));
        jLabel3.setText("Past Due");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        RecordTable2.setBackground(new java.awt.Color(156, 219, 155));
        RecordTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "StudentName", "VaccineName", "Dose", "Comming Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
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
        jScrollPane3.setViewportView(RecordTable2);
        if (RecordTable2.getColumnModel().getColumnCount() > 0) {
            RecordTable2.getColumnModel().getColumn(0).setResizable(false);
            RecordTable2.getColumnModel().getColumn(1).setResizable(false);
            RecordTable2.getColumnModel().getColumn(2).setResizable(false);
            RecordTable2.getColumnModel().getColumn(3).setResizable(false);
            RecordTable2.getColumnModel().getColumn(4).setResizable(false);
        }

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, 100));

        tbnView1.setBackground(new java.awt.Color(255, 255, 255));
        tbnView1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tbnView1.setText("View Detail");
        tbnView1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnView1ActionPerformed(evt);
            }
        });
        add(tbnView1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, 110, -1));

        tbnVacancies.setBackground(new java.awt.Color(255, 255, 255));
        tbnVacancies.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tbnVacancies.setText("View Records");
        tbnVacancies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnVacanciesActionPerformed(evt);
            }
        });
        add(tbnVacancies, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 120, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnBackActionPerformed

    
    
    private void tbnView1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnView1ActionPerformed
        // TODO add your handling code here:
        ViewStudent etp = new ViewStudent(rightPanel);
        rightPanel.removeAll();
        rightPanel.add("viewStudentJPanel",etp);
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.last(rightPanel);
    }//GEN-LAST:event_tbnView1ActionPerformed

    private void tbnVacanciesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnVacanciesActionPerformed
        // TODO add your handling code here:
        ViewStudentRecord etp = new ViewStudentRecord(rightPanel);
        rightPanel.removeAll();
        rightPanel.add("viewStudentRecordJPanel",etp);
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.last(rightPanel);
    }//GEN-LAST:event_tbnVacanciesActionPerformed

    private void backAction(){
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable RecordTable;
    private javax.swing.JTable RecordTable2;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton tbnVacancies;
    private javax.swing.JButton tbnView1;
    // End of variables declaration//GEN-END:variables
}
