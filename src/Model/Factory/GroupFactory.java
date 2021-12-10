/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Factory;

import Model.Organization.Group;

/**
 *
 * @author fuyanping
 */
public class GroupFactory extends AbstractFactory{
    @Override
    public Group getObject(String s){
        String[] fields=s.split(",");
        return new Group(Integer.parseInt(fields[0]),Integer.parseInt(fields[1]),fields[2]);
    }
    
}
