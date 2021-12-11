/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
    
/**
 *
 * @author fuyanping
 */
public class SqliteController {
    private static final String DB_URL ="jdbc:sqlite:Daycare.db";
    private static final String JDBC_DRIVER="Sqlite.JDBC";
    private static Connection conn=null;
    private static Statement stmt=null;
    private static ResultSet rs = null;
    private static PreparedStatement pstm=null;
    
    public static void main(String[] args){
        
    }
    public static void test(){
        //createSubjectTable();
        //createPersonTable();
        //createStudentSubjectTable();
        //createCourseTable();
        //createCourseEnrollTable();
       // createVaccineTable();
        //createImmunizationRecordTable();
        //deletedata();
        //insertSubjectTable(1,"damg");
        //getSubjectTable();
        //getAllCourse();
        //getCourseEnrollStudent(1);
        //getStudentEnroll(1);
        
    }
    public static void connDB(){
        try{
            //Class.forName(JDBC_DRIVER);
            conn=DriverManager.getConnection(DB_URL);
            stmt=conn.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void closeDB() {         
        if(rs != null ){              
            try {
              rs.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }              
        }          
        if(stmt != null){              
            try {
              stmt.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }
        }
        if(conn != null){
         try {
          conn.close();
            } catch (SQLException e) {
          e.printStackTrace();
             }
         }
    }
    
    
    public static void createSubjectTable(){
        connDB();
        //String dsql="drop table if exists Subject";
        String sql="create table IF NOT EXISTS Subject (SubjectID INTEGER PRIMARY KEY,SubjectName VARCHAR(45)) ";
        try{
            //stmt.executeUpdate(dsql);
            stmt.execute(sql);
        }catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		closeDB();
    	}
    }
    
    //using person table
    public static void createPersonTable(){
        connDB();
        //String dsql="drop table if exists Person";
        String sql="create table IF NOT EXISTS Person (id INTEGER PRIMARY KEY,fName VARCHAR(45),lName VARCHAR(45),Age INT,PIdentity VARCHAR(5)) ";
        try{
            //stmt.executeUpdate(dsql);
            stmt.execute(sql);
        }catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		closeDB();
    	}
    }
    public static void createStudentSubjectTable(){
        connDB();
        //String dsql="drop table if exists StudentSubject";
        String sql="create table IF NOT EXISTS StudentSubject (id INTEGER PRIMARY KEY REFERENCES person(id),"
                + "SubjectID INTEGER REFERENCES Subject(SubjectID)) ";
        try{
            //stmt.executeUpdate(dsql);
            stmt.execute(sql);
        }catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		closeDB();
    	}
    }

    public static void createCourseTable(){
        connDB();
        //String dsql="drop table if exists Course";
        String sql="create table IF NOT EXISTS Course (CourseID INTEGER PRIMARY KEY,"
                + "CourseName VARCHAR(200),StartDate DATE,EndDate DATE,DayOfWeek VARCHAR(15),StartTime TIME,"
                + "EndTime TIME,Location VARCHAR(200),SubjectID INTEGER REFERENCES Subject(SubjectID),tid INT REFERENCES person(id)"
                + ") ";
        try{
            //stmt.executeUpdate(dsql);
            stmt.execute(sql);
        }catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		closeDB();
    	}
    }
    
    public static void createCourseEnrollTable(){
        connDB();
        //String dsql="drop table if exists CourseEnrollment";
        String sql="create table IF NOT EXISTS CourseEnrollment (CourseID INTEGER REFERENCES Course(CourseID),"
                + "sid INTEGER REFERENCES Person(id),PRIMARY KEY(CourseID,sid)) ";
        try{
            //stmt.executeUpdate(dsql);
            stmt.execute(sql);
        }catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		closeDB();
    	}
    }
    //need update
    //*******************************
    public static void createVaccineTable(){
        connDB();
        //String dsql="drop table if exists Vaccine";
        String sql="create table IF NOT EXISTS Vaccine (VaccineID INTEGER PRIMARY KEY,"
                + "VaccineName VARCHAR(50),Rules VARCHAR(45),DoesRequired INT) ";
        try{
            //stmt.executeUpdate(dsql);
            stmt.execute(sql);
        }catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		closeDB();
    	}
    }
    //reference person table
    public static void createImmunizationRecordTable(){
        connDB();
        //String dsql="drop table if exists ImmunizationRecord";
        String sql="create table IF NOT EXISTS ImmunizationRecord (VaccineID INTEGER PRIMARY KEY REFERENCES Vaccine(VaccineID),"
                + "id INTEGER REFERENCES Person(id),LastVaccineDate DATE,DoseCompleted INT) ";
        try{
            //stmt.executeUpdate(dsql);
            stmt.execute(sql);
        }catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		closeDB();
    	}
    }
    
    public static List<Object[]> getAllTeacher(){
        connDB();
        String sql="SELECT * FROM Person WHERE PIdentity ='T'";
        List<Object[]> ol=new ArrayList<>();
        try{
            rs=stmt.executeQuery(sql);
                Object[] o=new Object[5];
    		while(rs.next()){
    			o[0]=rs.getInt("id");
                        o[0]=rs.getString("FirstName");
                        o[0]=rs.getString("LastName");
                        o[0]=rs.getInt("Age");
                        ol.add(o);
    		}
        }catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		closeDB();
    	}
        return ol;
    }
    //insert into Subject table
    public static void insertSubjectTable(int sid,String sName){
        connDB();
        
        String sql="INSERT INTO Subject VALUES (?,?)";
        try{
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1, sid);
            pstm.setString(2, sName);
            pstm.executeUpdate();
            //stmt.executeUpdate(sql);
        }catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		closeDB();
    	}
    }
    //insert into Course table
    public static void insertCourseTable(int cid,String cName,String sd,String ed,
            String st,String et,String wod,String loc,int sid,int tid){
        connDB();
        
        String sql="INSERT INTO Course VALUES (?,?,?,?,?,?,?,?,?,?)";
        try{
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1, cid);
            pstm.setString(2, cName);
            pstm.setString(3, sd);
            pstm.setString(4, ed);
            pstm.setString(5, st);
            pstm.setString(6, et);
            pstm.setString(7, wod);
            pstm.setString(8, loc);
            pstm.setInt(9, sid);
            pstm.setInt(10, tid);
            pstm.executeUpdate();
            //stmt.executeUpdate(sql);
        }catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		closeDB();
    	}
    }
    //insert into CourseEnroll table
    public static void insertCourseEnrollTable(int cid,int sid){
        connDB();
        
        String sql="INSERT INTO CourseEnroll VALUES (?,?)";
        try{
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1, cid);
            pstm.setInt(2, sid);
            pstm.executeUpdate();
            //stmt.executeUpdate(sql);
        }catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		closeDB();
    	}
    }
    //get all course info from DB
    public static List<Object[]> getAllCourse(){
        connDB();
        String sql="SELECT Course.CourseID,Course.CourseName,"
                + "Course.StartDate+'-'+Course.EndDate AS StartEndDate,"
                + "Course.DayOfWeek+' '+Course.StartTime+' - '+Course.EndTime AS Times,"
                + "Course.Location, Subject.SubjectName,"
                + "Person.fName+' '+Person.lName AS Instructor FROM Course "
                + "INNER JOIN Subject ON Subject.SubjectID=Course.SubjectID "
                + "INNER JOIN Person ON Person.id=Course.tid";
        List<Object[]> ol=new ArrayList<>();
        try{
            rs=stmt.executeQuery(sql);
                Object[] o=new Object[7];
    		while(rs.next()){
                    
    			o[0]=rs.getInt("CourseID");
                        o[1]=rs.getInt("CourseName");
                        o[2]=rs.getString("StartEndDate");
                        o[3]=rs.getString("Times");
                        o[4]=rs.getString("Location");
                        o[5]=rs.getString("SubjectName");
                        o[6]=rs.getString("Instructor");
                        ol.add(o);
    		}
                
        }catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		closeDB();
    	}
        return ol;
    }
    //get courseenroll by course id
    public static List<Object[]> getCourseEnrollStudent(int cid){
        connDB();
        String sql="SELECT Person.id, Person.fName+Person.lName AS Sname, Subject.SubjectName "
                + "FROM CourseEnrollment INNER JOIN Person ON CourseEnrollment.sid=Person.id "
                + "INNER JOIN StudentSubject ON StudentSubject.id=Person.id "
                + "INNER JOIN Subject ON Subject.SubjectID=StudentSubject.SubjectID "
                + "WHERE CourseEnrollment.CourseID = ?";
        
        List<Object[]> ol=new ArrayList<>();
        try{
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1, cid);
            rs=pstm.executeQuery();
            //rs=stmt.executeQuery(sql);
                Object[] o=new Object[3];
    		while(rs.next()){
                    System.out.println(rs.getInt("id"));
    			o[0]=rs.getInt("id");
                        o[1]=rs.getString("sName");
                        o[2]=rs.getString("SubjectName");
                        ol.add(o);
    		}
        }catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		closeDB();
    	}
        return ol;
    }
    //get student's all registered course
    public static List<Object[]> getStudentEnroll(int sid){
        connDB();
        String sql="SELECT  Course.CourseID,Course.CourseName,"
                + "Course.DayOfWeek+' '+Course.StartTime+' - '+Course.EndTime AS Times, "
                + "Course.Location, Subject.SubjectName,"
                + "Person.fName+' '+Person.lName AS Instructor "
                + "FROM CourseEnrollment "
                + "INNER JOIN Course ON Course.CourseID=CourseEnrollment.CourseID "
                + "INNER JOIN Subject ON Subject.SubjectID=Course.SubjectID "
                + "INNER JOIN Person ON Course.tid=Person.id "
                + "WHERE CourseEnrollment.sid = ?";
        
        List<Object[]> ol=new ArrayList<>();
        try{
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1, sid);
            rs=pstm.executeQuery();
            //rs=stmt.executeQuery(sql);
                Object[] o=new Object[6];
    		while(rs.next()){
    			o[0]=rs.getInt("CourseID");
                        o[1]=rs.getString("CourseName");
                        o[2]=rs.getString("Times");
                        o[3]=rs.getString("Location");
                        o[4]=rs.getString("SubjectName");
                        o[5]=rs.getString("Instructor");
                        ol.add(o);
    		}
        }catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		closeDB();
    	}
        return ol;
    }
    public static void deleteEnrollStudent(int cid,int sid){
        connDB();
        String sql="DELETE FROM CourseEnrollment WHERE CourseID = ? AND sid = ?";
        try{
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1, cid);
            pstm.setInt(2, sid);
            pstm.executeUpdate();
        }catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		closeDB();
    	}
    }
    
}
