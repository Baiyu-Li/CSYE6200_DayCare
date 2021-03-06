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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import medical.immunization.DateConverter;
import medical.immunization.VaccineEnum;
import medical.immunization.VaccineRecord;
import medical.immunization.VaccineRules;
import userInterface.Course.ViewCourse;

/**
 *
 * @author Floyed
 */
public class ViewStudentImmunization extends javax.swing.JPanel {

    JPanel container;
    
    String currentStudentName;
    int age;
    int studentId;
        
    /**
     * Creates new form manageTeacher
     */
    private CardLayout clayout;
    public ViewStudentImmunization(JPanel container, String currentStudentName, int age, int studentId) {
        initComponents();     
        this.container = container;
        SqliteController.test();
        clayout = (CardLayout) container.getLayout();
        this.currentStudentName = currentStudentName;
        jLabel7.setText("Manage Immunization records for: "+currentStudentName);
        this.age = age;
        this.studentId = studentId;

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

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(820, 520));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel7.setText("Immunization Records for Student: ");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, -1));

        RecordTable2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        RecordTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Name", "Completed Doses", "Required Doses", "Previous Dose Date", "Past Due Date", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
            RecordTable2.getColumnModel().getColumn(4).setResizable(false);
            RecordTable2.getColumnModel().getColumn(5).setMaxWidth(50);
        }

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 770, 200));

        tbnView1.setBackground(new java.awt.Color(255, 255, 255));
        tbnView1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tbnView1.setText("Update Vaccine Record Info");
        tbnView1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnView1ActionPerformed(evt);
            }
        });
        add(tbnView1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 350, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void tbnView1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnView1ActionPerformed
        // TODO add your handling code here:
        //((ViewStudent)this.container.getComponent(7)).setTable(SqliteController.getAllTeacher());

        if(!RecordTable2.getSelectionModel().isSelectionEmpty()){
            int row = RecordTable2.getSelectedRow();
            Object o = RecordTable2.getModel().getValueAt(row, 0);
                                                
            if(o !=null){
                
                String name=o.toString();
                
                String vacName = (String) o;
                int completedCount = (Integer)RecordTable2.getModel().getValueAt(row, 1);
                int reqCount = (Integer)RecordTable2.getModel().getValueAt(row,2);
                String lastDate = (String)RecordTable2.getModel().getValueAt(row, 3);
                String id = (String)RecordTable2.getModel().getValueAt(row, 5);
                
                /*
                JPanel container, String currentStudentName, 
            String vaccineName, int count, int reqCount, String doseDate, 
            int age
                */
                
                UpdateStudentVaccineRecord vsi = new UpdateStudentVaccineRecord(container, currentStudentName, vacName, 
                        completedCount, reqCount, lastDate, age, id);
                container.add(vsi);
                CardLayout layout = (CardLayout) container.getLayout();
                layout.next(container);
                
                
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please select a Vaccine record");
        }
        
    }//GEN-LAST:event_tbnView1ActionPerformed

    //import value from database
    public void setTableUpcoming(List<Object[]> ol){
        
        /*
            o[0]=rs.getString("ID");
            o[1]=rs.getString("studentId");
            o[2]=rs.getString("vaccineName");
            o[3]=rs.getString("vaccineId");
            o[4]=rs.getInt("vaccineCount");
            o[5]=rs.getString("lastDose");
        */
        DefaultTableModel tableModel=(DefaultTableModel) RecordTable2.getModel();
        tableModel.setColumnIdentifiers(new Object[]{"vaccineName", "vaccineCount", "requiredDose", "previousDoseDate", "due","ID"});
        
        while(tableModel.getRowCount() > 0){
            tableModel.removeRow(0);
        }
        
        for(Object[] o : ol){
            
            String vaccineName = String.valueOf(o[2]);
            
            Object[] row = new Object[6];
            row[0] = o[2];//vaccine name
            row[1] = o[4];//vaccine count
            row[2] = VaccineRules.getRuleForAge(age).getDoseRequired(VaccineEnum.valueOf(vaccineName));
            row[3] = o[5];//previous dose date
            row[4] = (o[5] != null && !o[5].equals("") && !o[5].equals("N/A") && (int)row[1] < (int)row[2]) 
                    ? isPastOneYear(String.valueOf(o[5])) 
                    : false;
            row[5] = o[0];
            
            tableModel.addRow(row);
        }
        
       RecordTable2.setModel(tableModel);
    }
    
    
    public boolean isPastOneYear(String date){
        
        Date current = DateConverter.getDateFromString(date);
        
        LocalDate today = LocalDate.now();

        Date oneYearPrev = Date.from(today.minusYears(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        if(current.before(oneYearPrev)){
            return true;
        }
        
        return false;

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable RecordTable2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton tbnView1;
    // End of variables declaration//GEN-END:variables
}
