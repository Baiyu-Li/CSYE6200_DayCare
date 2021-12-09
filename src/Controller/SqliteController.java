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
    private static final String DB_URL ="jdbc:sqlite:DB/Daycare.db";
    private static final String JDBC_DRIVER="Sqlite.JDBC";
    private static Connection conn=null;
    private static Statement stmt=null;
    private static ResultSet rs = null;
    
    public static void main(String[] args){
        
    }
    
    public static void connDB(){
        try{
            Class.forName(JDBC_DRIVER);
            conn=DriverManager.getConnection(DB_URL);
            if(conn!=null){
                System.out.println("Succeeded connecting to Sqlite!");
            }
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
          System.out.println("Database connection terminated!");
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
}
