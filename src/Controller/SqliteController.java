/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
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
    
    public static void main(String[] args){
        
    }
    public static void test(){
        createSubjectTable();
        createPersonTable();
        //createTeacherTable();
        //createStudentTable();
        createCourseTable();
        createCourseEnrollTable();
        createVaccineTable();
        //createStudentImmunizationRecordTable();
        //createTeacherImmunizationRecordTable();
    }
    public static void connDB(){
        try{
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
    public static List<Object[]> getAllTeacher(){
        connDB();
        String sql="SELECT * FROM Teachers";
        List<Object[]> ol=new ArrayList<>();
        try{
            rs=stmt.executeQuery(sql);
                Object[] o=new Object[5];
    		while(rs.next()){
    			o[0]=rs.getInt("id");
                        o[0]=rs.getString("FirstName");
                        o[0]=rs.getString("LastName");
                        o[0]=rs.getInt("Age");
                        o[0]=rs.getInt("Group");
                        ol.add(o);
    		}
        }catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		closeDB();
    	}
        return ol;
    }
    
    public static void createSubjectTable(){
        connDB();
        //String dsql="drop table Subject";
        String sql="create table IF NOT EXISTS Subject (SubjectID INTEGER PRIMARY KEY AUTOINCREMENT,SubjectName VARCHAR(45)) ";
        try{
            //stmt.execute(dsql);
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
        //String dsql="drop table Subject";
        String sql="create table IF NOT EXISTS Person (id INTEGER PRIMARY KEY AUTOINCREMENT,fName VARCHAR(45),lName VARCHAR(45),Age INT,PIdentity VARCHAR(10)) ";
        try{
            //stmt.execute(dsql);
            stmt.execute(sql);
        }catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		closeDB();
    	}
    }
    /*2 tables
    public static void createTeacherTable(){
        connDB();
        //String dsql="drop table Subject";
        String sql="create table IF NOT EXISTS Teachers (tid INTEGER PRIMARY KEY AUTOINCREMENT,fName VARCHAR(45),lName VARCHAR(45),Age INT) ";
        try{
            //stmt.execute(dsql);
            stmt.execute(sql);
        }catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		closeDB();
    	}
    }
    public static void createStudentTable(){
        connDB();
        //String dsql="drop table Subject";
        String sql="create table IF NOT EXISTS Students (sid INTEGER PRIMARY KEY AUTOINCREMENT,fName VARCHAR(45),lName VARCHAR(45),Age INT,SubjectID INT REFERENCES Subject(SubjectID)) ";
        try{
            //stmt.execute(dsql);
            stmt.execute(sql);
        }catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		closeDB();
    	}
    }
*/
    public static void createCourseTable(){
        connDB();
        //String dsql="drop table Subject";
        String sql="create table IF NOT EXISTS Course (CourseID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "CourseName VARCHAR(200),StartDate DATE,EndDate DATE,DayOfWeek VARCHAR(15),StartTime TIME,"
                + "EndTime TIME,SubjectID INT REFERENCES Subject(SubjectID),tid INT REFERENCES Teachers(tid)) ";
        try{
            //stmt.execute(dsql);
            stmt.execute(sql);
        }catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		closeDB();
    	}
    }
    
    public static void createCourseEnrollTable(){
        connDB();
        //String dsql="drop table Subject";
        String sql="create table IF NOT EXISTS CourseEnroll (CourseID INTEGER REFERENCES Course(CourseID),"
                + "sid INTEGER REFERENCES Students(sid),PRIMARY KEY(CourseID,sid)) ";
        try{
            //stmt.execute(dsql);
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
        //String dsql="drop table Subject";
        String sql="create table IF NOT EXISTS Vaccine (VaccineID INTEGER PRIMARY KEY,"
                + "sid INTEGER REFERENCES Students(sid)) ";
        try{
            //stmt.execute(dsql);
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
        //String dsql="drop table Subject";
        String sql="create table IF NOT EXISTS ImmunizationRecord (VaccineID INTEGER PRIMARY KEY REFERENCES Vaccine(VaccineID),"
                + "id INTEGER REFERENCES Person(id),ImmunizedDate DATE,DoseCompleted INT) ";
        try{
            //stmt.execute(dsql);
            stmt.execute(sql);
        }catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		closeDB();
    	}
    }
    /*teacher and student 2 kinds*****************
    //need update
    //*******************************
    public static void createStudentImmunizationRecordTable(){
        connDB();
        //String dsql="drop table Subject";
        String sql="create table IF NOT EXISTS ImmunizationRecord (VaccineID INTEGER PRIMARY KEY REFERENCES Vaccine(VaccineID),"
                + "sid INTEGER REFERENCES Students(sid),ImmunizedDate DATE,DoseCompleted INT) ";
        try{
            //stmt.execute(dsql);
            stmt.execute(sql);
        }catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		closeDB();
    	}
    }
    //need update
    //*******************************
    public static void createTeacherImmunizationRecordTable(){
        connDB();
        //String dsql="drop table Subject";
        String sql="create table IF NOT EXISTS ImmunizationRecord (VaccineID INTEGER PRIMARY KEY REFERENCES Vaccine(VaccineID),"
                + "sid INTEGER REFERENCES Students(sid),ImmunizedDate DATE,DoseCompleted INT) ";
        try{
            //stmt.execute(dsql);
            stmt.execute(sql);
        }catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		closeDB();
    	}
    }
*/
    public static void insertSubjectTable(){
        connDB();
        
        String sql="INSERT INTO Subject(SubjectName) VALUES ('csye')";
        try{
            stmt.executeUpdate(sql);
        }catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		closeDB();
    	}
    }
    
    public static void getSubjectTable(){
        connDB();
        String sql="SELECT * FROM Subject";
        try{
            rs=stmt.executeQuery(sql);
            if(rs.next()){
                System.out.println(rs.getInt("SubjectID"));
            }
        }catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		closeDB();
    	}
    }
}
