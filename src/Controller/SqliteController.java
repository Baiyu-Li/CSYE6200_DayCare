/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

//import static SqliteController.connDB;
import Model.Factory.CourseFactory;
import Model.Factory.StudentFactory;
import Model.Factory.SubjectFactory;
import Model.Factory.TeacherFactory;
import Model.Organization.Course;
import Model.Organization.Subject;
import Model.Person.Student;
import Model.Person.Teacher;
import medical.immunization.IDGenerator;
import medical.immunization.VaccineEnum;
import medical.immunization.VaccineRecord;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author fuyanping
 */
public class SqliteController {
    private static final String DB_URL = "jdbc:sqlite:Daycare.db";
    private static final String JDBC_DRIVER = "org.sqlite.JDBC";
//    private static PreparedStatement pstm = null;

    public static void main(String[] args) {

    }

    public static void test() {
        /*
        createSubjectTable();
        createPersonTable();
        createStudentSubjectTable();
        createCourseTable();
        createCourseEnrollTable();
        createVaccineTable();
        createImmunizationRecordTable();
        */
        //deletedata();
        //insertSubjectTable(1,"damg");
        //getSubjectTable();
        //getAllCourse();
        //getCourseEnrollStudent(1);
        //getStudentEnroll(1);
        //getalltable();
        /*
        insertSubjectTable("Computer Engineering Systems");
        insertSubjectTable("Information Systems");
        insertSubjectTable("Data Architecture Management");
        insertStudent("aaa", "bbb", "123456789", "boston neu", "2021",1, "aaa", "bbb", 23, "Female");
        insertStudent("max", "min", "124567342", "boston neu1", "2021",1, "lee", "aaa", 24, "Female");
        insertStudent("han", "ann", "167895689", "boston neu2", "2021",2, "anna", "ddd", 23, "Male");
        insertTeacher("abc", "lol", 45,"Male","aaa","bbb",
                "23456789","1 xxx st");
        insertTeacher("ann", "bbb", 39,"Female","sss","fff",
                "56788789","2 zzz st");
        insertCourseTable("Concepts of Object-Oriented Design","2022-01-18","2022-05-07","Monday",
                "18:00:00","21:30:00","Building A Room 320",1,4);
        insertCourseTable("Network Structures and Cloud Computing","2022-01-18","2022-05-07","Thursday",
                "15:00:00","18:00:00","Building B Room 120",1,5);
        insertCourseEnrollTable(1, 1);
        insertCourseEnrollTable(1, 3);
        insertCourseEnrollTable(2, 2);
        */
    }

    public static DbConn connDB() {
        try {
//            Class.forName(JDBC_DRIVER);
            return new DbConn(DriverManager.getConnection(DB_URL));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void createSubjectTable() {
        DbConn dbConn = connDB();
        Statement stmt = dbConn.getStmt();
        String dsql="drop table if exists Subject";
        String sql = "create table IF NOT EXISTS Subject (SubjectID INTEGER PRIMARY KEY AUTOINCREMENT,SubjectName VARCHAR(45)) ";
        try {
            stmt.executeUpdate(dsql);
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
    }

    //using person table
    public static void createPersonTable() {
        DbConn dbConn = connDB();
        Statement stmt = dbConn.getStmt();
        String dsql="drop table if exists Person";
        String sql = "create table IF NOT EXISTS Person (id INTEGER PRIMARY KEY AUTOINCREMENT,fName VARCHAR(45),lName VARCHAR(45),Age INT,gender VARCHAR(5),"
                + "PIdentity VARCHAR(5),fatherName VARCHAR(45),motherName VARCHAR(45),phone VARCHAR(45),address VARCHAR(150)) ";
        try {
            stmt.executeUpdate(dsql);
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
    }

    public static void createStudentSubjectTable() {
        DbConn dbConn = connDB();
        Statement stmt = dbConn.getStmt();
        String dsql="drop table if exists StudentSubject";
        String sql = "create table IF NOT EXISTS StudentSubject (id INTEGER PRIMARY KEY REFERENCES person(id),"
                + "SubjectID INTEGER REFERENCES Subject(SubjectID),entryYear INT) ";
        try {
            stmt.executeUpdate(dsql);
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
    }

    public static void createCourseTable() {
        DbConn dbConn = connDB();
        Statement stmt = dbConn.getStmt();
        String dsql="drop table if exists Course";
        String sql = "create table IF NOT EXISTS Course (CourseID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "CourseName VARCHAR(200),StartDate DATE,EndDate DATE,DayOfWeek VARCHAR(15),StartTime TIME,"
                + "EndTime TIME,Location VARCHAR(200),SubjectID INTEGER REFERENCES Subject(SubjectID),tid INT REFERENCES person(id)"
                + ") ";
        try {
            stmt.executeUpdate(dsql);
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
    }

    public static void createCourseEnrollTable() {
        DbConn dbConn = connDB();
        Statement stmt = dbConn.getStmt();
        String dsql="drop table if exists CourseEnrollment";
        String sql = "create table IF NOT EXISTS CourseEnrollment (CourseID INTEGER REFERENCES Course(CourseID),"
                + "sid INTEGER REFERENCES Person(id),PRIMARY KEY(CourseID,sid)) ";
        try {
            stmt.executeUpdate(dsql);
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
    }

    //need update
    //*******************************
    public static void createVaccineTable() {
        DbConn dbConn = connDB();
        Statement stmt = dbConn.getStmt();
        String dsql="drop table if exists Vaccine";
        String sql = "create table IF NOT EXISTS Vaccine (VaccineID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "VaccineName VARCHAR(50),Rules VARCHAR(45),DoesRequired INT) ";
        try {
            stmt.executeUpdate(dsql);
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
    }

    //reference person table
    public static void createImmunizationRecordTable() {
        DbConn dbConn = connDB();
        Statement stmt = dbConn.getStmt();
        String dsql="drop table if exists ImmunizationRecord";
        String sql = "create table IF NOT EXISTS ImmunizationRecord (VaccineID INTEGER PRIMARY KEY REFERENCES Vaccine(VaccineID),"
                + "id INTEGER REFERENCES Person(id),LastVaccineDate DATE,DoseCompleted INT) ";
        try {
            stmt.executeUpdate(dsql);
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
    }


    public static List<Object[]> getAllTeacher() {
        DbConn dbConn = connDB();
        Statement stmt = dbConn.getStmt();
        String sql = "SELECT * FROM Person WHERE PIdentity ='T'";
        List<Object[]> ol = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery(sql);
            dbConn.setRs(rs);
            Object[] o = new Object[5];
            while (rs.next()) {
                o[0] = rs.getInt("id");
                o[1] = rs.getString("FirstName");
                o[2] = rs.getString("LastName");
                o[3] = rs.getInt("Age");
                ol.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
        return ol;
    }

    public static int insertPerson(String fName, String lName, int age, String gender,String fathern,String mothern,String phone,String address, String pIdentity) {
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        String sql = "INSERT INTO Person (fName, lName, Age, PIdentity, gender,fatherName,motherName,phone,address) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, fName);
            pstm.setString(2, lName);
            pstm.setInt(3, age);
            pstm.setString(4, pIdentity);
            pstm.setString(5, gender);
             pstm.setString(6, fathern);
              pstm.setString(7, mothern);
               pstm.setString(8, phone);
                pstm.setString(9, address);
              
            pstm.executeUpdate();
            ResultSet resultSet = pstm.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
        return -1;
    }

    //insert into Course table
    public static int insertCourseFactoryTable(Course c){
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        int i=0;
        String sql="INSERT INTO Course(CourseName,StartDate,EndDate,DayOfWeek,StartTime,EndTime,Location,SubjectID,tid) VALUES (?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, c.getCourseName());
            pstm.setString(2, c.getStartDate());
            pstm.setString(3, c.getEndDate());
            pstm.setString(4, c.getWeekOfDay());
            pstm.setString(5, c.getStartTime());
            pstm.setString(6, c.getEndTime());
            pstm.setString(7, c.getLocation());
            pstm.setInt(8, c.getSubjectID());
            pstm.setInt(9, c.getteacherID());
            i=pstm.executeUpdate();
            //stmt.executeUpdate(sql);
        }catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		dbConn.closeDB();
    	}
        return i;
    }
    
    public static boolean updatePerson(int id, String fName, String lName, int Age, String gender, String pIdentity) {
        boolean result;
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        String sql = "UPDATE Person SET fName = ?, lName = ?, Age = ?, gender = ? WHERE id = ? AND PIdentity = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, fName);
            pstm.setString(2, lName);
            pstm.setInt(3, Age);
            pstm.setString(4, gender);
            pstm.setInt(5, id);
            pstm.setString(6, pIdentity);
            result = pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            result = false;
        } finally {
            dbConn.closeDB();
        }
        return result;
    }

    public static boolean deletePerson(int id, String pIdentity) {
        boolean result;
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        String sql = "DELETE from Person WHERE id = ? AND PIdentity = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.setString(2, pIdentity);
            result = pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            result = false;
        } finally {
            dbConn.closeDB();
        }
        return result;
    }

    public static List<Teacher> getAllTeacherModel() {
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        String sql = "SELECT * FROM Person WHERE PIdentity = ?";
        List<Object[]> ol = new ArrayList<>();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, Teacher.PIdentity);
            ResultSet rs = pstm.executeQuery();
            dbConn.setRs(rs);
            while (rs.next()) {
                int id = rs.getInt("id");
                Object[] o = new Object[6];
                o[0] = rs.getString("lName");
                o[1] = rs.getString("fName");
                o[2] = rs.getString("gender");
                o[3] = rs.getInt("Age");
                o[4] = id;
                o[5] = SqliteController.getCourseModelByTeacherId(id);
                ol.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
        return TeacherFactory.getObjectList(ol.toArray());
    }

    public static Teacher getTeacherModelById(int id) {
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        String sql = "SELECT * FROM Person WHERE PIdentity = ? and id = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, Teacher.PIdentity);
            pstm.setInt(2, id);
            ResultSet rs = pstm.executeQuery();
            dbConn.setRs(rs);
            while (rs.next()) {
                Object[] o = new Object[6];
                o[0] = rs.getString("lName");
                o[1] = rs.getString("fName");
                o[2] = rs.getString("gender");
                o[3] = rs.getInt("Age");
                o[4] = id;
                o[5] = SqliteController.getCourseModelByTeacherId(id);
                return TeacherFactory.getObject(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
        return null;
    }

    public static int insertTeacher(String fName, String lName, int age, String gender,String fathern,String mothern,String phone,String address) {
        return SqliteController.insertPerson(fName,lName,age,gender,fathern,mothern,phone,address, Teacher.PIdentity);
    }

    public static boolean updateTeacher(int id, String fName, String lName, int age, String gender) {
        return SqliteController.updatePerson(id, fName, lName, age, gender, Teacher.PIdentity);
    }

    public static boolean deleteTeacher(int id) {
        SqliteController.deleteCourseTid(id);
        return SqliteController.deletePerson(id, Teacher.PIdentity);
    }

    public static List<Student> getAllStudentModel() {
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        String sql = "SELECT * FROM StudentSubject AS ss " +
                "LEFT JOIN Person AS p ON p.id = ss.id  " +
                "LEFT JOIN CourseEnrollment AS ce ON ce.sid = p.id " +
                "WHERE p.PIdentity = ?";
        List<Object[]> ol = new ArrayList<>();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, Student.PIdentity);
            ResultSet rs = pstm.executeQuery();
            dbConn.setRs(rs);
            while (rs.next()) {
                Object[] o = new Object[12];
                o[0] = rs.getString("lName");
                o[1] = rs.getString("fName");
                o[2] = rs.getString("gender");
                o[3] = rs.getInt("Age");
                o[4] = rs.getInt("id");
                o[5] = rs.getString("fatherName");
                o[6] = rs.getString("motherName");
                o[7] = rs.getString("entryYear");
                o[8] = rs.getString("phone");
                o[9] = rs.getString("address");
                o[10] = SqliteController.getSubjectModelById(rs.getInt("subjectId"));
                //get what
                List<Course> cl=SqliteController.getCourseModelByStudentId(rs.getInt("id"));
                if(cl.isEmpty()){
                    o[11]=null;
                }else{
                o[11] = cl.get(0);
                }
                ol.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
        
        Object[][] data=new Object[ol.size()][];
        int i=0;
        for(Object[] o:ol){
            data[i]=o;
            i++;
        }
        return StudentFactory.getObjectList(data);
    }

    public static List<Object[]> getStudentByCourseId(int courseId) {
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        String sql = "SELECT * FROM CourseEnrollment " +
                "LEFT JOIN Person ON Person.id = CourseEnrollment.sid  "
                + "LEFT JOIN StudentSubject ON Person.id = StudentSubject.id  " +
                 "LEFT JOIN Subject ON Subject.SubjectID = StudentSubject.SubjectID  " +
                "WHERE Person.PIdentity = ? AND CourseEnrollment.CourseID = ?";
        List<Object[]> ol = new ArrayList<>();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, Student.PIdentity);
            pstm.setInt(2, courseId);
            ResultSet rs = pstm.executeQuery();
            dbConn.setRs(rs);
            while (rs.next()) {
                Object[] o = new Object[6];
                o[0] = rs.getInt("id");
                o[1] = rs.getString("fName")+" "+rs.getString("lName");
                o[2] = rs.getString("gender");
                o[3] = rs.getInt("Age");
                o[4] = rs.getString("SubjectName");
                o[5] = rs.getString("entryYear");
                ol.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
        
        
        return ol;
    }

    public static Student getStudentModelById(int id) {
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        String sql = "SELECT * FROM StudentSubject " +
                "LEFT JOIN Person ON StudentSubject.id = Person.id  " +
                "LEFT JOIN CourseEnrollment ON CourseEnrollment.sid = Person.id " +
                "WHERE Person.PIdentity = ? AND Person.id = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, Student.PIdentity);
            pstm.setInt(2, id);
            ResultSet rs = pstm.executeQuery();
            dbConn.setRs(rs);
            while (rs.next()) {
                Object[] o = new Object[12];
                o[0] = rs.getString("lName");
                o[1] = rs.getString("fName");
                o[2] = rs.getString("gender");
                o[3] = rs.getInt("Age");
                o[4] = rs.getInt("id");
                o[5] = rs.getString("fatherName");
                o[6] = rs.getString("motherName");
                o[7] = rs.getString("entryYear");
                o[8] = rs.getString("phone");
                o[9] = rs.getString("address");
                o[10] = SqliteController.getSubjectModelById(rs.getInt("subjectId"));
                o[11] = SqliteController.getCourseModelById(rs.getInt("CourseID"));
                return StudentFactory.getObject(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
        return null;
    }


    public static int insertStudent(String fathern, String mothern, String phone, String address, String entryYear,
                                    int subjectId, String fName, String lName, int age, String gender) {
        int personId = SqliteController.insertPerson(fName, lName, age, gender,fathern,mothern,phone,address,Student.PIdentity);
        if (personId < 0) {
            return personId;
        }
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        String sql = "INSERT INTO StudentSubject (id,entryYear, subjectId) VALUES (?,?,?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, personId);
            pstm.setString(2, entryYear);
            pstm.setInt(3, subjectId);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
        return personId;
    }

    public static boolean updateStudent(int id, String fatherName, String motherName, String phone, String address,
                                        String fName, String lName, int age, String gender) {
        boolean result = SqliteController.updatePerson(id, fName, lName, age, gender, Student.PIdentity);
        if (!result) {
            return false;
        }
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        String sql = "UPDATE Person SET fatherName = ?, motherName = ?, phone = ?, address = ? WHERE id = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, fatherName);
            pstm.setString(2, motherName);
            pstm.setString(3, phone);
            pstm.setString(4, address);
            pstm.setInt(5, id);
            result = pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            result = false;
        } finally {
            dbConn.closeDB();
        }
        return result;
    }

    public static boolean deleteStudent(int id) {
        boolean result = SqliteController.deletePerson(id, Student.PIdentity);
        if (!result) {
            return false;
        }
        SqliteController.deleteCourseEnrollBySid(id);
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        String sql = "DELETE from student WHERE pid = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            result = pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            //result = false;
        } finally {
            dbConn.closeDB();
        }
        return result;
    }

    //insert into Subject table
    public static void insertSubjectTable(String sName) {
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();

        String sql = "INSERT INTO Subject (SubjectName) VALUES (?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, sName);
            pstm.executeUpdate();
            //stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
    }

    public static void deleteCourseTid(int tid) {
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        String sql = "UPDATE Course set tid = 0 WHERE tid = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, tid);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
    }

    public static void updateCourseTid(int cid, int tid) {
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        String sql = "UPDATE Course set tid = ? WHERE CourseID = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, tid);
            pstm.setInt(2, cid);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
    }

    //insert into Course table
    public static void insertCourseTable(String cName, String sd, String ed, String wod,
                                         String st, String et, String loc, int sid, int tid) {
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();

        String sql = "INSERT INTO Course (CourseName, StartDate, EndDate, StartTime, EndTime, DayOfWeek, Location, SubjectID, tid) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, cName);
            pstm.setString(2, sd);
            pstm.setString(3, ed);
            pstm.setString(4, st);
            pstm.setString(5, et);
            pstm.setString(6, wod);
            pstm.setString(7, loc);
            pstm.setInt(8, sid);
            pstm.setInt(9, tid);
            pstm.executeUpdate();
            //stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
    }

    //insert into CourseEnroll table
    public static int insertCourseEnrollTable(int cid, int sid) {
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        int i=0;
        String sql = "INSERT INTO CourseEnrollment (CourseID, sid) VALUES (?,?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, cid);
            pstm.setInt(2, sid);
            i=pstm.executeUpdate();
            //stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
        return i;
    }

    public static void deleteCourseEnrollBySid(int sid) {
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        String sql = "DELETE from CourseEnrollment WHERE sid = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, sid);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
    }

    //get all course info from DB

    public static List<Object[]> getAllCourse() {
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        String sql = "SELECT Course.CourseID,Course.CourseName,"
                + "(Course.StartDate||'~'||Course.EndDate) AS StartEndDate,"
                + "(Course.DayOfWeek||' '||Course.StartTime||' ~ '||Course.EndTime) AS Times,"
                + "Course.Location, Subject.SubjectName,"
                + "(Person.fName||' '||Person.lName) AS Instructor FROM Course "
                + "INNER JOIN Subject ON Subject.SubjectID=Course.SubjectID "
                + "INNER JOIN Person ON Person.id=Course.tid";
        //
        List<Object[]> ol = new ArrayList<>();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            dbConn.setRs(rs);
            while (rs.next()) {
                Object[] o = new Object[7];
                o[0] = rs.getInt("CourseID");
                o[1] = rs.getString("CourseName");
                o[2] = rs.getString("StartEndDate");
                o[3] = rs.getString("Times");
                o[4] = rs.getString("Location");
                o[5] = rs.getString("SubjectName");
                o[6] = rs.getString("Instructor");
                System.out.println(rs.getString("Instructor"));
                ol.add(o);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
        return ol;
    }

    public static List<Course> getAllCourseModel() {
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        String sql = "SELECT * FROM Course";
        List<Object[]> ol = new ArrayList<>();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            dbConn.setRs(rs);
            while (rs.next()) {
                Object[] o = new Object[10];
                o[0] = rs.getInt("CourseID");
                o[1] = rs.getString("CourseName");
                o[2] = rs.getString("StartDate");
                o[3] = rs.getString("EndDate");
                o[4] = rs.getString("StartTime");
                o[5] = rs.getString("EndTime");
                o[6] = rs.getString("DayOfWeek");
                o[7] = rs.getString("Location");
                o[8] = rs.getInt("SubjectID");
                o[9] = rs.getInt("tid");
                ol.add(o);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
        return CourseFactory.getObjectList(ol.toArray());
    }

    public static List<Course> getCourseModelBySubjectId(int subjectId) {
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        String sql = "SELECT * FROM Course where SubjectID = ?";
        List<Object[]> ol = new ArrayList<>();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, subjectId);
            ResultSet rs = pstm.executeQuery();
            dbConn.setRs(rs);
            while (rs.next()) {
                Object[] o = new Object[10];
                o[0] = rs.getInt("CourseID");
                o[1] = rs.getString("CourseName");
                o[2] = rs.getString("StartDate");
                o[3] = rs.getString("EndDate");
                o[4] = rs.getString("StartTime");
                o[5] = rs.getString("EndTime");
                o[6] = rs.getString("DayOfWeek");
                o[7] = rs.getString("Location");
                o[8] = rs.getInt("SubjectID");
                o[9] = rs.getInt("tid");
                ol.add(o);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
        return CourseFactory.getObjectList(ol.toArray());
    }

    public static List<Course> getCourseModelByStudentId(int student) {
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        String sql = "SELECT * FROM Course LEFI JOIN CourseEnrollment WHERE CourseEnrollment.sid = ?";
        List<Object[]> ol = new ArrayList<>();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, student);
            ResultSet rs = pstm.executeQuery();
            dbConn.setRs(rs);
            while (rs.next()) {
                Object[] o = new Object[10];
                o[0] = rs.getInt("CourseID");
                o[1] = rs.getString("CourseName");
                o[2] = rs.getString("StartDate");
                o[3] = rs.getString("EndDate");
                o[4] = rs.getString("StartTime");
                o[5] = rs.getString("EndTime");
                o[6] = rs.getString("DayOfWeek");
                o[7] = rs.getString("Location");
                o[8] = rs.getInt("SubjectID");
                o[9] = rs.getInt("tid");
                ol.add(o);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
        return CourseFactory.getObjectList(ol.toArray());
    }

    public static Course getCourseModelById(int id) {
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        String sql = "SELECT * FROM Course where CourseID = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            dbConn.setRs(rs);
            while (rs.next()) {
                Object[] o = new Object[10];
                o[0] = rs.getInt("CourseID");
                o[1] = rs.getString("CourseName");
                o[2] = rs.getString("StartDate");
                o[3] = rs.getString("EndDate");
                o[4] = rs.getString("StartTime");
                o[5] = rs.getString("EndTime");
                o[6] = rs.getString("DayOfWeek");
                o[7] = rs.getString("Location");
                o[8] = rs.getInt("SubjectID");
                o[9] = rs.getInt("tid");
                return CourseFactory.getObject(o);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
        return null;
    }

    public static Course getCourseModelByTeacherId(int pid) {
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        String sql = "SELECT * FROM Course where tid = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, pid);
            ResultSet rs = pstm.executeQuery();
            dbConn.setRs(rs);
            while (rs.next()) {
                Object[] o = new Object[10];
                o[0] = rs.getInt("CourseID");
                o[1] = rs.getString("CourseName");
                o[2] = rs.getString("StartDate");
                o[3] = rs.getString("EndDate");
                o[4] = rs.getString("StartTime");
                o[5] = rs.getString("EndTime");
                o[6] = rs.getString("DayOfWeek");
                o[7] = rs.getString("Location");
                o[8] = rs.getInt("SubjectID");
                o[9] = rs.getInt("tid");
                return CourseFactory.getObject(o);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
        return null;
    }
    
     public static List<Object[]> getCourseByTeacherId(int pid) {
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        String sql = "SELECT * FROM Course where tid = ?";
        List<Object[]> ol = new ArrayList<>();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, pid);
            ResultSet rs = pstm.executeQuery();
            dbConn.setRs(rs);
            while (rs.next()) {
                Object[] o = new Object[10];
                o[0] = rs.getInt("CourseID");
                o[1] = rs.getString("CourseName");
                o[2] = rs.getString("StartDate");
                o[3] = rs.getString("EndDate");
                o[4] = rs.getString("StartTime");
                o[5] = rs.getString("EndTime");
                o[6] = rs.getString("DayOfWeek");
                o[7] = rs.getString("Location");
                o[8] = rs.getInt("SubjectID");
                o[9] = rs.getInt("tid");
                ol.add(o);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
        return ol;
    }

    public static List<Subject> getAllSubjectModel() {
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        String sql = "SELECT * FROM Subject";
        List<Object[]> ol = new ArrayList<>();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            dbConn.setRs(rs);
            while (rs.next()) {
                Object[] o = new Object[2];
                o[0] = rs.getInt("SubjectID");
                o[1] = rs.getString("SubjectName");
                ol.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
        return SubjectFactory.getObjectList(ol.toArray());
    }

    public static Subject getSubjectModelById(int id) {
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        String sql = "SELECT * FROM Subject where SubjectID = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            dbConn.setRs(rs);
            while (rs.next()) {
                Object[] o = new Object[2];
                o[0] = rs.getInt("SubjectID");
                o[1] = rs.getString("SubjectName");
                return SubjectFactory.getObject(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
        return null;
    }

    //get courseenroll by course id
    public static List<Object[]> getCourseEnrollStudent(int cid) {
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        String sql = "SELECT Person.id, Person.fName,Person.lName, Subject.SubjectName "
                + "FROM CourseEnrollment INNER JOIN Person ON CourseEnrollment.sid=Person.id "
                + "INNER JOIN StudentSubject ON StudentSubject.id=Person.id "
                + "INNER JOIN Subject ON Subject.SubjectID=StudentSubject.SubjectID "
                + "WHERE CourseEnrollment.CourseID = ?";

        List<Object[]> ol = new ArrayList<>();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, cid);
            ResultSet rs = pstm.executeQuery();
            dbConn.setRs(rs);
            //rs=stmt.executeQuery(sql);
            while (rs.next()) {
                Object[] o = new Object[4];
                o[0] = rs.getInt("id");
                o[1] = rs.getString("fName");
                o[2] = rs.getString("lName");
                o[3] = rs.getString("SubjectName");
                ol.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
        return ol;
    }

    //get student's all registered course
    public static List<Object[]> getStudentEnroll(int sid) {
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        String sql = "SELECT  Course.CourseID,Course.CourseName,"
                + "Course.DayOfWeek+' '+Course.StartTime+' - '+Course.EndTime AS Times, "
                + "Course.Location, Subject.SubjectName,"
                + "Person.fName+' '+Person.lName AS Instructor "
                + "FROM CourseEnrollment "
                + "INNER JOIN Course ON Course.CourseID=CourseEnrollment.CourseID "
                + "INNER JOIN Subject ON Subject.SubjectID=Course.SubjectID "
                + "INNER JOIN Person ON Course.tid=Person.id "
                + "WHERE CourseEnrollment.sid = ?";

        List<Object[]> ol = new ArrayList<>();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, sid);
            ResultSet rs = pstm.executeQuery();
            dbConn.setRs(rs);
            //rs=stmt.executeQuery(sql);
            while (rs.next()) {
                Object[] o = new Object[6];
                o[0] = rs.getInt("CourseID");
                o[1] = rs.getString("CourseName");
                o[2] = rs.getString("Times");
                o[3] = rs.getString("Location");
                o[4] = rs.getString("SubjectName");
                o[5] = rs.getString("Instructor");
                ol.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
        return ol;
    }

    public static int  deleteEnrollStudent(int cid,int sid){
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        int i=0;
        String sql="DELETE FROM CourseEnrollment WHERE CourseID = ? AND sid = ?";
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1, cid);
            pstm.setInt(2, sid);
            i=pstm.executeUpdate();
        }catch(SQLException e){
    		JOptionPane.showMessageDialog(null, "Failed to delete");
    	}finally{
    		dbConn.closeDB();
    	}
        return i;
    }
    public static int deleteCourseRow(int cid){
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        int i=0;
        String sql="DELETE FROM Course WHERE CourseID = ?";
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1, cid);
            i=pstm.executeUpdate();
        }catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		dbConn.closeDB();
    	}
        return i;
    }
    public static int  deleteCourseEnrollRow(int cid){
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        int i=0;
        String sql="DELETE FROM CourseEnrollment WHERE CourseID = ?";
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1, cid);
            i=pstm.executeUpdate();
        }catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		dbConn.closeDB();
    	}
        return i;
    }
    
    public static void createVaccineRecordTable(){
         DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        Statement stmt=dbConn.getStmt();
         //String dsql="drop table if exists Subject";
         String sql="create table IF NOT EXISTS VaccineRecord "
                 + "(ID VARCHAR(45) PRIMARY KEY,"
                 + "studentId INTEGER,"
                 + "vaccineName VARCHAR(45),"
                 + " vaccineCount INTEGER,"
                 + "vaccineId INTEGER,"
                 + "lastDoseDate VARCHAR(45)) ";
         try{
             //stmt.executeUpdate(dsql);
             stmt.execute(sql);
         }catch(SQLException e){
     		e.printStackTrace();
     	}finally{
     		dbConn.closeDB();
     	}
     }

     public static List<Object[]> getAllStudents(){
         /*connDB();
         List<Object[]> ol=new ArrayList<>();
         Object[] o=new Object[6];
         o[0]="123";//id
         o[1]="max";//firstname
         o[2]="John";//last name
         o[3]=19;//age
         o[4]="Male";//gender
         o[5]="2021-12-12"; //lastdate
         ol.add(o);
         return ol;
         */
         DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        String sql = "SELECT * FROM StudentSubject AS ss " +
                "LEFT JOIN Person AS p ON p.id = ss.id  " +
//                "LEFT JOIN VaccineRecord AS vr ON vr.studentId = p.id " +
                "WHERE p.PIdentity = ?";
        List<Object[]> ol = new ArrayList<>();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, Student.PIdentity);
            ResultSet rs = pstm.executeQuery();
            dbConn.setRs(rs);
            while (rs.next()) {
                Object[] o = new Object[5];
                o[0] = rs.getInt("id");
                o[1] = rs.getString("fName");
                o[2] = rs.getString("lName");
                o[4] = rs.getString("gender");
                o[3] = rs.getInt("Age");
//                o[5] = rs.getString("lastDoseDate");
                ol.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeDB();
        }
        
        
        return ol;
     }
 public static boolean areVaccineRecordsPresentForStudent(String studentId){
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
         try{
             String sql = "SELECT vr.ID FROM VaccineRecord vr " 
                 + " WHERE vr.studentId = '"+studentId+"'";
            PreparedStatement pstm = conn.prepareStatement(sql);
                         ResultSet rs = pstm.executeQuery();

             Object o = rs.next();

             if(o instanceof Boolean){

                 return (boolean)o;
             } 

             return false;

         }catch(SQLException e){
     		e.printStackTrace();
     	}finally{
     		dbConn.closeDB();
     	}

         return false;
     }
 
     public static void generateVaccineRecordsForStudent(String studentId){

         DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();

          try{
             String sql="INSERT INTO VaccineRecord (ID,studentId,vaccineName,vaccineCount,vaccineId,lastDoseDate)"
                     + " VALUES (?,?,?,?,?,?)";

             for (VaccineEnum v : VaccineEnum.values()) {
                 PreparedStatement pstm = conn.prepareStatement(sql);
                 //pstm=conn.prepareStatement(sql);
                 pstm.setString(1, IDGenerator.getId());
                 pstm.setString(2, studentId);
                 pstm.setString(3, v.toString());
                 pstm.setInt(4, 0);
                 pstm.setString(5, null);
                 pstm.setString(6, null);
                 pstm.executeUpdate();
                 //stmt.executeUpdate(sql);
             }
         }catch(SQLException e){
     		e.printStackTrace();
     	}finally{
     		dbConn.closeDB();
     	}

     }

     public static void updateVaccineRecordsForStudent(String vrId, String newDate, int newCount){
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();

          try{
             String sql="Update VaccineRecord "
                     + " set lastDoseDate = '"+newDate+"', "
                     + " vaccineCount = '" +newCount+"' "
                     + " where id = '"+vrId+"'";
             PreparedStatement pstm = conn.prepareStatement(sql);
             pstm.executeUpdate();

         }catch(SQLException e){
     		e.printStackTrace();
     	}finally{
     		dbConn.closeDB();
     	}

     }

     public static List<Object[]> getAllVaccineRecordsForStudent(String studentId){
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
         String sql="SELECT vr.ID as ID,"
                 + "vr.studentId as studentId,"
                 + "vr.vaccineName as vaccineName,"
                 + "vr.vaccineId as vaccineId,"
                 + "vr.lastDoseDate as lastDose ,"
                 + "vr.vaccineCount as vaccineCount "
                 + "FROM VaccineRecord vr "
                 + " where vr.studentId = '"+studentId+"'";
         List<Object[]> ol=new ArrayList<>();
         try{
             Statement stmt=dbConn.getStmt();
             ResultSet rs=stmt.executeQuery(sql);
                while(rs.next()){

                 Object[] o=new Object[7];
                 o[0]=rs.getString("ID");
                 o[1]=rs.getString("studentId");
                 o[2]=rs.getString("vaccineName");
                 o[3]=rs.getString("vaccineId");
                 o[4]=rs.getInt("vaccineCount");
                 o[5]=rs.getString("lastDose");
                 ol.add(o);
     		}

         }catch(SQLException e){
     		e.printStackTrace();
     	}finally{
     		dbConn.closeDB();
     	}
         return ol;
     }
     
     public static int insertCourseTablewithstring(String s){
        DbConn dbConn = connDB();
        Connection conn = dbConn.getConn();
        int i=0;
        String sql="INSERT INTO Course  VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        String[] fields = s.split(",");
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, fields[1]);
            pstm.setString(2, fields[2]);
            pstm.setString(3, fields[3]);
            pstm.setString(4, fields[4]);
            pstm.setString(5, fields[5]);
            pstm.setString(6, fields[6]);
            pstm.setString(7, fields[7]);
            pstm.setInt(8, Integer.parseInt(fields[8]));
            pstm.setInt(9, Integer.parseInt(fields[9]));
            i=pstm.executeUpdate();
            ResultSet rs = pstm.getGeneratedKeys();
                if(rs.next())
                {
                   System.out.println(rs.getInt(1));
                    
                }
                
            SqliteController.getAllCourse();
            //stmt.executeUpdate(sql);
        }catch(SQLException e){
      e.printStackTrace();
     }finally{
      dbConn.closeDB();
     }
        return i;
    }
}
