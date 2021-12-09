/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Factory;

import Model.Organization.Subject;

/**
 *
 * @author fuyanping
 */
public class SubjectFactory extends AbstractFactory{
    @Override
    public Subject getObject(String s){
        String[] fields=s.split(",");
        return new Subject(Integer.parseInt(fields[0]),fields[1]);
    }
}
