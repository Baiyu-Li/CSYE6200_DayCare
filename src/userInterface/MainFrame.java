/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package userInterface;


import Controller.MainController;
import Controller.SqliteController;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import userInterface.Course.ManageCourse;
import userInterface.Course.ViewCourse;
import userInterface.Immunization.ViewStudentImmunization;
import userInterface.Registration.AnnualRegistration;
import userInterface.Registration.StudentAnnualRegistration;
import userInterface.Registration.TeacherAnnualRegistration;
import userInterface.Student.AddRecord;
import userInterface.Student.EnrollStudent;
import userInterface.Student.ManageStudent;
import userInterface.Student.ViewStudent;
import userInterface.Student.ViewStudentRecord;
import userInterface.Student.ViewStudentUpcomming;
import userInterface.Teacher.EnrollTeacher;
import userInterface.Teacher.ManageTeacher;
import userInterface.Teacher.ViewTeacher;

/**
 *
 * @author 83715
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public CardLayout clayout;
    public MainFrame() {
        initComponents();
        
        clayout=(CardLayout)container.getLayout();
        //add jpanel to container
        ManageTeacher mtp = new ManageTeacher(container);
        ManageStudent msp = new ManageStudent(container);
        ViewStudentImmunization mip = new ViewStudentImmunization(container);
        ManageCourse mcp = new ManageCourse(container);
        ViewCourse vcp = new ViewCourse(container);
        ViewStudentRecord srp = new ViewStudentRecord(container);
        ViewStudent vsp = new ViewStudent(container);
        TeacherAnnualRegistration tap = new TeacherAnnualRegistration(container);
        StudentAnnualRegistration sap = new StudentAnnualRegistration(container);
        EnrollStudent esp = new EnrollStudent(container);
        ViewStudentUpcomming sup = new ViewStudentUpcomming(container);
        AddRecord arp = new AddRecord(container);
        ViewTeacher vtp = new ViewTeacher(container);
        EnrollTeacher etp = new EnrollTeacher(container);
                        
        container.add("teacherManage", mtp);//1
        container.add("studentManage", msp);//2
        container.add("immunizationManage", mip);//3
        container.add("courseManage", mcp);//4
        container.add("viewCourseJPanel",vcp);//5
        container.add("viewStudentRecordJPanel",srp);//6
        container.add("viewStudentJPanel",vsp);//7
        container.add("TeacherAnnualRegistrationJPanel",tap);//8
        container.add("StudentAnnualRegistrationJPanel",sap);//9
        container.add("enrollStudentJPanel",esp);//10
        container.add("viewStudentUpcommingJPanel",sup);//11
        container.add("addRecordJPanel",arp);//12
        container.add("viewTeacherJPanel",vtp);//13
        container.add("enrollTeacherJPanel",etp);//14

        MainController mc=new MainController(this,container);
        SqliteController.test();
        this.teacherShow(e-> clayout.show(container, "teacherManage"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        rightPanel = new javax.swing.JPanel();
        logoPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        workPanel = new javax.swing.JPanel();
        immunization = new javax.swing.JButton();
        teacher = new javax.swing.JButton();
        student = new javax.swing.JButton();
        course = new javax.swing.JButton();
        registration = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        container.setBackground(new java.awt.Color(249, 253, 255));
        container.setLayout(new java.awt.CardLayout());

        rightPanel.setBackground(new java.awt.Color(249, 253, 255));
        rightPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        container.add(rightPanel, "card2");

        getContentPane().add(container, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 650, 400));

        logoPanel.setBackground(new java.awt.Color(229, 242, 255));
        logoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userInterface/images.jpeg"))); // NOI18N
        logoPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, -1, -1));

        getContentPane().add(logoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 650, 90));

        workPanel.setBackground(new java.awt.Color(153, 204, 255));
        workPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        immunization.setBackground(new java.awt.Color(255, 255, 255));
        immunization.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        immunization.setText("Immunization");
        immunization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                immunizationActionPerformed(evt);
            }
        });
        workPanel.add(immunization, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 110, -1));

        teacher.setBackground(new java.awt.Color(255, 255, 255));
        teacher.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        teacher.setText("Teacher");
        teacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherActionPerformed(evt);
            }
        });
        workPanel.add(teacher, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 110, -1));

        student.setBackground(new java.awt.Color(255, 255, 255));
        student.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        student.setText("Student");
        student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentActionPerformed(evt);
            }
        });
        workPanel.add(student, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 110, -1));

        course.setBackground(new java.awt.Color(255, 255, 255));
        course.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        course.setText("Course");
        course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseActionPerformed(evt);
            }
        });
        workPanel.add(course, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 110, -1));

        registration.setBackground(new java.awt.Color(255, 255, 255));
        registration.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        registration.setText("Registration");
        registration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrationActionPerformed(evt);
            }
        });
        workPanel.add(registration, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 110, -1));

        getContentPane().add(workPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void immunizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_immunizationActionPerformed
        ((ViewStudentImmunization)this.container.getComponent(3)).setTableUpcoming(SqliteController.getAllTeacher());
        //container layout show() display panel with name
        clayout.show(container, "immunizationManage");
        
    }//GEN-LAST:event_immunizationActionPerformed
    public void teacherShow(ActionListener actionListener) {
        teacher.addActionListener(actionListener);
    }
    private void studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentActionPerformed
        ((ManageStudent)this.container.getComponent(2)).setTable(SqliteController.getAllTeacher());
        clayout.show(container, "studentManage");
        //container.removeAll();
        //container.add(mtp);
        //pack();
        /*
        rightPanel.removeAll();
        rightPanel.add("ManageStudentJPanel",mtp);
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.last(rightPanel);
        */
    }//GEN-LAST:event_studentActionPerformed

    private void courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseActionPerformed
        // TODO add your handling code here:
        ((ManageCourse)this.container.getComponent(4)).setTable(SqliteController.getAllTeacher());
        clayout.show(container, "courseManage");
        //container.removeAll();
        //container.add(mtp);
        //pack();
        /*
        rightPanel.removeAll();
        rightPanel.add("ManageClassroomJPanel",mtp);
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.last(rightPanel);
        */
    }//GEN-LAST:event_courseActionPerformed

    private void registrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrationActionPerformed
        // TODO add your handling code here:
        /*AnnualRegistration mtp = new AnnualRegistration(container);
        container.removeAll();
        container.add(mtp);
        pack();*/
        /*
        rightPanel.removeAll();
        rightPanel.add("AnnualRegistrationJPanel",mtp);
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.last(rightPanel);
        */
    }//GEN-LAST:event_registrationActionPerformed

    private void teacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teacherActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container;
    private javax.swing.JButton course;
    private javax.swing.JButton immunization;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel logoPanel;
    private javax.swing.JButton registration;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JButton student;
    private javax.swing.JButton teacher;
    private javax.swing.JPanel workPanel;
    // End of variables declaration//GEN-END:variables
}
