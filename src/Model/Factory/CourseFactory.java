/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Factory;

import Model.Organization.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fuyanping
 */
public class CourseFactory extends AbstractFactory{
    @Override
    public Course getObjectwithString(String s) {
        String[] fields = s.split(",");
        return new Course(Integer.parseInt(fields[0]), fields[1], fields[2], fields[3], fields[4],
                fields[5], fields[6], fields[7],Integer.parseInt(fields[8]),Integer.parseInt(fields[9]));
    }
    //@Override
    public static Course getObject(Object[] data) {
        Course course = new Course((int)data[0], (String) data[1], (String) data[2], (String) data[3], (String) data[4],
                (String) data[5], (String) data[6], (String) data[7]);
        course.setSubjectId((int) data[8]);
        course.setTid((int) data[9]);
        return course;
    }

    public static List<Course> getObjectList(Object[] data) {
        List<Course> list = new ArrayList<>();
        for (Object obj: data){
            Course c=CourseFactory.getObject((Object[]) obj);
            list.add(c);
        }
        return list;
    }


}
