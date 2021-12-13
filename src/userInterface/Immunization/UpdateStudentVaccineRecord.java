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
import medical.immunization.DateConverter;
import medical.immunization.VaccineEnum;
import medical.immunization.VaccineRecord;
import medical.immunization.VaccineRules;
import userInterface.Course.ViewCourse;

/**
 *
 * @author Floyed
 */
public class UpdateStudentVaccineRecord extends javax.swing.JPanel {

    JPanel container;
    
    String currentStudentName;
    
    /*
    Object[] row = new Object[5];
    row[0] = o[2];//vaccine name
    row[1] = o[4];//vaccine count
    row[2] = VaccineRules.getRuleForAge(age).getDoseRequired(VaccineEnum.valueOf(vaccineName));
    row[3] = o[5];//previous dose date
    row[4] = false;
    */
    
    String vaccineRecordId;
    String vaccineName, doseDate;
    int vaccineCount, reqCount;
    
    /**
     * Creates new form manageTeacher
     */
    private CardLayout clayout;
    public UpdateStudentVaccineRecord(JPanel container, String currentStudentName, 
            String vaccineName, int count, int reqCount, String doseDate, 
            int age, String vrId) {
        initComponents();     
        this.container = container;
        SqliteController.test();
        clayout = (CardLayout) container.getLayout();
        this.currentStudentName = currentStudentName;
        jLabel7.setText("Manage Immunization records for: "+currentStudentName);
                
        this.vaccineName = vaccineName;
        this.doseDate = doseDate;
        this.vaccineCount = count;
        this.reqCount = reqCount;
        this.vaccineRecordId = vrId;
        
        this.vaccineCountField.setText(String.valueOf(vaccineCount));
        this.vaccineNameField.setText(String.valueOf(this.vaccineName));
        this.reqCountField.setText(String.valueOf(this.reqCount));
        this.lastDostDate1.setText(String.valueOf(this.doseDate == null ? "" : this.doseDate));
        
    }

    public boolean isValidNumber(String number){
        
        try{
            Integer.parseInt(number);
        } catch(NumberFormatException ne){
            ne.printStackTrace();
            return false;
        }
        
        return true;
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
        tbnView1 = new javax.swing.JButton();
        vaccineCountField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        reqCountField = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lastDostDate1 = new javax.swing.JTextField();
        vaccineNameField = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(820, 520));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel7.setText("Update Records for Student: ");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, -1));

        tbnView1.setBackground(new java.awt.Color(255, 255, 255));
        tbnView1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tbnView1.setText("Update Vaccine Info");
        tbnView1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnView1ActionPerformed(evt);
            }
        });
        add(tbnView1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, -1, -1));

        vaccineCountField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        vaccineCountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vaccineCountFieldActionPerformed(evt);
            }
        });
        add(vaccineCountField, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 120, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Last Vaccine dose date");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Vaccine Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, -1, -1));

        reqCountField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        reqCountField.setText("reqCountField");
        add(reqCountField, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Vaccine Required Count");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Vaccine Count");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, -1, -1));

        lastDostDate1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lastDostDate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastDostDate1ActionPerformed(evt);
            }
        });
        add(lastDostDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, 120, -1));

        vaccineNameField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        vaccineNameField.setText("vaccineNameField");
        add(vaccineNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void tbnView1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnView1ActionPerformed
        // TODO add your handling code here:
        //((ViewStudent)this.container.getComponent(7)).setTable(SqliteController.getAllTeacher());
        
        
        if(this.vaccineCountField.getText() != null 
                && !this.vaccineCountField.getText().equals("")
                && !isValidNumber(this.vaccineCountField.getText())){
            
            JOptionPane.showMessageDialog(null, "Please enter a correct vaccine count");
            return;
        }
        
        if(this.lastDostDate1.getText() != null 
                && !this.lastDostDate1.getText().equals("") &&
                !DateConverter.isValidString(this.lastDostDate1.getText())){
            
            JOptionPane.showMessageDialog(null, "Please enter a correct date");
            return;
        }
        
        
       SqliteController.updateVaccineRecordsForStudent(vaccineRecordId, this.lastDostDate1.getText(), Integer.valueOf(this.vaccineCountField.getText()));
       
       container.remove(this);
       
        Component[] componentArray = container.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ViewStudentImmunization msi = (ViewStudentImmunization) component;
//        sysAdminwjp.populateTable();
        

        msi.setTableUpcoming(SqliteController.getAllVaccineRecordsForStudent(String.valueOf(msi.studentId)));

//        msi.setTable(SqliteController.getAllStudents());
        
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
        

    }//GEN-LAST:event_tbnView1ActionPerformed

    private void vaccineCountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vaccineCountFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vaccineCountFieldActionPerformed

    private void lastDostDate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastDostDate1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastDostDate1ActionPerformed

    //import value from database
    public void setTableUpcoming(List<Object[]> ol){
        
//        /*
//            o[0]=rs.getString("ID");
//            o[1]=rs.getString("studentId");
//            o[2]=rs.getString("vaccineName");
//            o[3]=rs.getString("vaccineId");
//            o[4]=rs.getInt("vaccineCount");
//            o[5]=rs.getString("lastDose");
//        */
//        DefaultTableModel tableModel=(DefaultTableModel) RecordTable2.getModel();
//        tableModel.setColumnIdentifiers(new Object[]{"vaccineName", "vaccineCount", "requiredDose", "previousDoseDate", "due"});
//        
//        for(Object[] o : ol){
//            
//            String vaccineName = String.valueOf(o[2]);
//            
//            Object[] row = new Object[5];
//            row[0] = o[2];//vaccine name
//            row[1] = o[4];//vaccine count
//            row[2] = VaccineRules.getRuleForAge(age).getDoseRequired(VaccineEnum.valueOf(vaccineName));
//            row[3] = o[5];//previous dose date
//            row[4] = false;
//            
//            tableModel.addRow(row);
//        }
//        
//       RecordTable2.setModel(tableModel);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField lastDostDate1;
    private javax.swing.JLabel reqCountField;
    private javax.swing.JButton tbnView1;
    private javax.swing.JTextField vaccineCountField;
    private javax.swing.JLabel vaccineNameField;
    // End of variables declaration//GEN-END:variables
}