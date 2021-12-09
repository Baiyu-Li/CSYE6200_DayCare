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
        //createSubjectTable();
        //createPersonTable();
        //createStudentSubjectTable();
        //createCourseTable();
        //createCourseEnrollTable();
       // createVaccineTable();
        //createImmunizationRecordTable();
        
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
                + "EndTime TIME,Location VARCHAR(200),SubjectID INTEGER REFERENCES Subject(SubjectID),tid INT REFERENCES person(id)) ";
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
