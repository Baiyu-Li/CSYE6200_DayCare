/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Factory;

import Model.Organization.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fuyanping
 */
public class SubjectFactory extends AbstractFactory{
    @Override
    public Subject getObjectwithString(String s){
        String[] fields=s.split(",");
        return new Subject(Integer.parseInt(fields[0]),fields[1]);
    }

    public static Subject getObject(Object[] data){
        return new Subject((int) data[0], (String) data[1]);
    }


    public static List<Subject> getObjectList(Object[] data) {
        List<Subject> list = new ArrayList<>();
        for (Object obj: data){
            list.add(SubjectFactory.getObject((Object[]) obj));
        }
        return list;
    }
}
