/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Factory;

import Model.Organization.Course;

/**
 *
 * @author fuyanping
 */
public class CourseFactory extends AbstractFactory{
    @Override
    public Course getObject(String s){
        String[] fields=s.split(",");
        return new Course(Integer.parseInt(fields[0]),fields[1],fields[2],fields[3],fields[4],
                fields[5],fields[6],fields[7],Integer.parseInt(fields[8]),Integer.parseInt(fields[9]));
    }
    
}
