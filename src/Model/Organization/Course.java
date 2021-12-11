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
public class Course extends AbstractOrganization{
    private int cid;
    private String cName;
    private String startdate;
    private String enddate;
    private String starttime;
    private String endtime;
    private String weekofday;
    private String location;
    private int subID;
    private int tID;
    
    private List<String> glist=new ArrayList<>();
    /*
     *constructor with parameters initial with all data
     */
    public Course(int cid,String cName,String startdate,String enddate,String starttime,String endtime,String weekofday,String location,int subid,int tid){
        this.cid=cid;
        this.cName=cName;
        this.startdate=startdate;
        this.enddate=enddate;
        this.starttime=starttime;
        this.endtime=endtime;
        this.weekofday=weekofday;
        this.location=location;
        this.subID=subID;
        this.tID=tID;
    }
    
    //get data value
    public int getCourseId(){
        return this.cid;
    }
    public String getCourseName(){
        return this.cName;
    }
    public String getStartDate(){
        return this.startdate;
    }
    public String getEndDate(){
        return this.enddate;
    }
    public String getStartTime(){
        return this.starttime;
    }
    public String getEndTime(){
        return this.endtime;
    }
    public String getWeekOfDay(){
        return this.weekofday;
    }
    public String getLocation(){
        return this.location;
    }
    public int getSubjectID(){
        return this.subID;
    }
    public int getteacherID(){
        return this.tID;
    }
    @Override
    public void showOrganization(){
        
    }
}
