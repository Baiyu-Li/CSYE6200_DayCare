/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userInterface.Immunization;

import Controller.SqliteController;
import userInterface.Student.*;
import userInterface.Teacher.*;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userInterface.Course.ViewCourse;

/**
 *
 * @author Floyed
 */
public class ViewStudentImmunization extends javax.swing.JPanel {

    JPanel container;
    
    String currentStudentName;
    
    int updateRow = -1;
    
    /**
     * Creates new form manageTeacher
     */
    private CardLayout clayout;
    public ViewStudentImmunization(JPanel container, String currentStudentName) {
        initComponents();     
        this.container = container;
        SqliteController.test();
        clayout = (CardLayout) container.getLayout();
        this.currentStudentName = currentStudentName;
        updateRowButton.setVisible(false);
        jLabel7.setText("Manage Immunization records for: "+currentStudentName);

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
        jScrollPane3 = new javax.swing.JScrollPane();
        RecordTable2 = new javax.swing.JTable();
        tbnView1 = new javax.swing.JButton();
        updateRowButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(650, 400));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel7.setText("Immunization Records for student: ");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        RecordTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Vaccine name", "Completed doses", "Required Doses", "Previous dose Date", "Past due date?"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class
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
        tbnView1.setText("Update Vaccine info");
        tbnView1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnView1ActionPerformed(evt);
            }
        });
        add(tbnView1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, -1, -1));

        updateRowButton.setText("Update");
        updateRowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateRowButtonActionPerformed(evt);
            }
        });
        add(updateRowButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void tbnView1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnView1ActionPerformed
        // TODO add your handling code here:
        //((ViewStudent)this.container.getComponent(7)).setTable(SqliteController.getAllTeacher());
        
        ManageStudentImmunization msi = new ManageStudentImmunization(container);
        
        clayout.addLayoutComponent(msi, container);
        
        
        if(!RecordTable2.getSelectionModel().isSelectionEmpty()){
            int row=RecordTable2.getSelectedRow();
            Object o=RecordTable2.getModel().getValueAt(row, 1);
            
            RecordTable2.setEditingRow(row);
            
            updateRow = row;
            
            updateRowButton.setVisible(true);
            
            if(o !=null){
                int sid=Integer.parseInt(o.toString());
                String name=o.toString();

                ViewStudentImmunization vsi = new ViewStudentImmunization(container, name);

                clayout.show(container, "viewStudentImmunizationJPanel");
                
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please select a Vaccine record");
        }
        
    }//GEN-LAST:event_tbnView1ActionPerformed

    private void updateRowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateRowButtonActionPerformed
        // TODO add your handling code here:
        
                updateRowButton.setVisible(false);
        
    }//GEN-LAST:event_updateRowButtonActionPerformed

    //import value from database
    public void setTableUpcoming(List<Object[]> ol){
        DefaultTableModel tableModel=(DefaultTableModel) RecordTable2.getModel();
        tableModel.setColumnIdentifiers(new Object[]{"ID", "FirstName", "LastName", "Age", "Group"});
        //tableModel.setColumnIdentifiers(new Object[]{"ID", "FirstName", "LastName", "Age", "VaccineName","LastVacccinedDate","DoesCompleted"}); 
        ol.forEach((e)-> {tableModel.addRow(e);});
       RecordTable2.setModel(tableModel);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable RecordTable2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton tbnView1;
    private javax.swing.JButton updateRowButton;
    // End of variables declaration//GEN-END:variables
}
