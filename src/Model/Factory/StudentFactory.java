package Model.Factory;

import Model.Organization.Course;
import Model.Organization.Subject;
import Model.Person.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fuyanping
 */
public class StudentFactory {
    /*
    public static Student getObject(String s) {
        String[] fields = s.split(",");
        return new Student(fields[0], fields[1], fields[2], Integer.parseInt(fields[3]), fields[4], fields[5], fields[6],
                fields[7], fields[8], fields[9], SubjectFactory.getObject(fields[11]), CourseFactory.getObjecwithString(fields[12]));
    }
*/
    public static Student getObject(Object[] data) {
        return new Student((String) data[0], (String) data[1], (String) data[2], (int) data[3], String.valueOf(data[4]),
                (String) data[5], (String) data[6], (String) data[7], (String) data[8], (String) data[9],
                (Subject) data[10], (Course) data[11]);
    }

    public static List<Student> getObjectList(Object[][] data) {
        List<Student> list = new ArrayList<>();
        for (Object[] obj: data){
            list.add(StudentFactory.getObject((Object[]) obj));
        }
        return list;
    }
}
