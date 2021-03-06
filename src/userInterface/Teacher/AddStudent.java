/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userInterface.Teacher;

import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author 83715
 */
public class AddStudent extends javax.swing.JPanel {

    JPanel rightPanel;
    
    /**
     * Creates new form manageTeacher
     */
    public AddStudent(JPanel rp) {
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
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        StudentTable = new javax.swing.JTable();
        tbnEnrollStudent = new javax.swing.JButton();

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
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 90, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Teacher");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel7.setText("Assign Student to Teacher");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, 30, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setText("Student List");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        StudentTable.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        StudentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "FirstName", "LastName", "Age"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
        jScrollPane2.setViewportView(StudentTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, 120));

        tbnEnrollStudent.setBackground(new java.awt.Color(255, 255, 255));
        tbnEnrollStudent.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tbnEnrollStudent.setText("Add Student");
        tbnEnrollStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnEnrollStudentActionPerformed(evt);
            }
        });
        add(tbnEnrollStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 120, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        ViewTeacher etp = new ViewTeacher(rightPanel);
        rightPanel.remove(this);
        rightPanel.add(etp);
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.previous(rightPanel);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void tbnEnrollStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnEnrollStudentActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_tbnEnrollStudentActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable StudentTable;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton tbnEnrollStudent;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
