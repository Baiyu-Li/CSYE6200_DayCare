/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Organization;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fuyanping
 */
public class Subject extends AbstractOrganization{
    private int sid;
    private String subjectname;
    
    List<Course> crlist=new ArrayList<>();
    public Subject(int id,String subjectname){
        this.sid=id;
        this.subjectname=subjectname;
    }
    public int getSubjectID(){
        return this.sid;
   
    }
     public String getSubjectName(){
        return this.subjectname;
   
    }
    @Override
    public void showOrganization(){
        
    }
    
}
