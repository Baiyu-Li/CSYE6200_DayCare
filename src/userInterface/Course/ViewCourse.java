/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userInterface.Course;

import Controller.CourseController;
import Controller.SqliteController;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userInterface.Student.ViewStudent;

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
        courseNameLabel.setText(ManageCourse.selectedCourse);
        courseId.setText(ManageCourse.selectedCourseId+"");
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
        courseId = new javax.swing.JTextField();
        courseNameLabel = new javax.swing.JLabel();
        btnBack6 = new javax.swing.JButton();
        tbnViewStudent = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(820, 520));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
            enrolledStudentTable.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 550, 190));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Student Enrolled");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, -1, -1));

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 80, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("ID");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, -1, -1));

        courseId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseIdActionPerformed(evt);
            }
        });
        add(courseId, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 40, -1));

        courseNameLabel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        courseNameLabel.setText("Course Details");
        add(courseNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, -1));

        btnBack6.setBackground(new java.awt.Color(255, 255, 255));
        btnBack6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnBack6.setText("<< Back");
        btnBack6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack6ActionPerformed(evt);
            }
        });
        add(btnBack6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, -1));

        tbnViewStudent.setBackground(new java.awt.Color(255, 255, 255));
        tbnViewStudent.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tbnViewStudent.setText("View Detail");
        tbnViewStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnViewStudentActionPerformed(evt);
            }
        });
        add(tbnViewStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 360, 110, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(!enrolledStudentTable.getSelectionModel().isSelectionEmpty()){
            int row=enrolledStudentTable.getSelectedRow();
            Object o=enrolledStudentTable.getModel().getValueAt(row, 0);
            if(o !=null){
                int sid=Integer.parseInt(o.toString());
                CourseController cc=new CourseController(container);
                System.out.println(ManageCourse.selectedCourseId+"cid "+sid);
                cc.removeEnrollStudent(ManageCourse.selectedCourseId, sid);
            }else{
                JOptionPane.showMessageDialog(null, "no student register this course, can not delete.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please select one student to delete ^ ^");
        }
        
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void courseIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseIdActionPerformed

    private void btnBack6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack6ActionPerformed
        CourseController cc=new CourseController(container);
            cc.showCourseTabelfromDB();
        clayout.show(container, "courseManage");
    }//GEN-LAST:event_btnBack6ActionPerformed

    private void tbnViewStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnViewStudentActionPerformed
        // TODO add your handling code here:
        int row = enrolledStudentTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }else{
        int id = Integer.parseInt(enrolledStudentTable.getValueAt(row, 0).toString());
        ViewStudent vs=(ViewStudent)this.container.getComponent(12);
        vs.setStudnetID(id);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.show(container,"ViewStudent");
        }
    }//GEN-LAST:event_tbnViewStudentActionPerformed

    public void setTable(List<Object[]> ol){
        DefaultTableModel tableModel=(DefaultTableModel) enrolledStudentTable.getModel(); 
        if (tableModel.getRowCount() > 0) {
                    for (int i = tableModel.getRowCount() - 1; i > -1; i--) {
                        tableModel.removeRow(i);
                    }
                }
        ol.forEach((e)-> {tableModel.insertRow(ol.indexOf(e),e);});
       enrolledStudentTable.setModel(tableModel);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack6;
    private javax.swing.JButton btnDelete;
    private javax.swing.JTextField courseId;
    private javax.swing.JLabel courseNameLabel;
    private javax.swing.JTable enrolledStudentTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton tbnViewStudent;
    // End of variables declaration//GEN-END:variables
}
