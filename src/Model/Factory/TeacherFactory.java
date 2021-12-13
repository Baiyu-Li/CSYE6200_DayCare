package Model.Factory;

import Model.Organization.Course;
import Model.Person.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fuyanping
 */
public class TeacherFactory {
    /*
    public static Teacher getObject(String s) {
        String[] fields = s.split(",");
        return new Teacher(fields[0], fields[1], fields[2], Integer.parseInt(fields[3]),
                fields[4], CourseFactory.getObject(fields[5]));
    }
    */
    public static Teacher getObject(Object[] data) {
        return new Teacher((String) data[0], (String) data[1], (String) data[2], (int) data[3],
                String.valueOf(data[4]), (Course) data[5]);
    }

    public static List<Teacher> getObjectList(Object[] data) {
        List<Teacher> list = new ArrayList<>();
        for (Object obj: data){
            list.add(TeacherFactory.getObject((Object[]) obj));
        }
        return list;
    }
}
