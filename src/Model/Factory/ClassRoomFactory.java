/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Factory;

import Model.Organization.ClassRoom;

/**
 *
 * @author fuyanping
 */
public class ClassRoomFactory extends AbstractFactory{
    @Override
    public ClassRoom getObject(String s){
        String[] fields=s.split(",");
        return new ClassRoom(Integer.parseInt(fields[0]),fields[1],Integer.parseInt(fields[2]));
    }
}
