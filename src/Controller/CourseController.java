/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Factory.AbstractFactory;
import Model.Factory.CourseFactory;
import Model.Factory.SubjectFactory;
import Model.Organization.Course;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import userInterface.Course.ManageCourse;
import userInterface.Course.ViewCourse;

/**
 *
 * @author fuyanping
 */
public class CourseController {
    private JPanel container;
    private AbstractFactory cf;
    private AbstractFactory sf;
    public static List<Object[]> clist=new ArrayList<>();
    public static List<Object[]> cEnrolllist=new ArrayList<>();
    
    public CourseController(JPanel container){
        this.container=container;
        cf=new CourseFactory();
        sf=new SubjectFactory();
    }
    
    public void showCourseTabelfromDB(){
        clist=SqliteController.getAllCourse();
        showCoursewithList();
    }
    public void showCoursewithList(){
        ((ManageCourse)this.container.getComponent(4)).setTable(clist);
    }
    public void viewCourseEnrollDetailfromDB(int cid){
        cEnrolllist=SqliteController.getCourseEnrollStudent(cid);
        viewCourseEnrollDetail();
    }
    public void viewCourseEnrollDetail(){
        ((ViewCourse)this.container.getComponent(5)).setTable(cEnrolllist);
    }
    public void removeEnrollStudent(int cid,int sid){
        SqliteController.deleteEnrollStudent(cid, sid);
        showCourseTabelfromDB();
    }
}
