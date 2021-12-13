/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.swing.JPanel;
import userInterface.MainFrame;
import userInterface.Teacher.ManageTeacher;

/**
 *
 * @author fuyanping
 */
public class MainController {
    private MainFrame mframe;
    private JPanel container;
    private ManageTeacher manageteacher;
    public MainController(MainFrame mf,JPanel container){
        this.mframe=mf;
        this.container=container;
        mframe.teacherShow(e-> {
            manageteacher=(ManageTeacher)this.container.getComponent(1);
            //pass list<object[]>(by resultset) to settable()
            manageteacher.refreshTable();
        });
       
    }
    
    public void addCoursesFromCSV(){
        
    }
    
}
