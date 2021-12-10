/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Organization;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fuyanping
 */
public class ClassRoom extends AbstractOrganization{
    private int id;
    private String crtype;
    private int capacity;
    private int teacherId;
    List<Group> crlist=new ArrayList<>();
    public ClassRoom(int id,String crType,int capacity){
        this.id=id;
        this.crtype=crType;
        this.capacity=capacity;
    }
    
    public int getClassRoomID(){
        return this.id;
    }
    public void setTeacher(int i){
        this.teacherId=i;
    }
    public void addGroup(Group g){
        if(this.crlist.size()<this.capacity&&!this.crlist.contains(g)){
            this.crlist.add(g);
        }
    }
    public void removeGroup(Group g){
        if(this.crlist.size()>0&&this.crlist.contains(g)){
            this.crlist.remove(g);
        }
    }
    @Override
    public void showOrganization(){
        
    }
    
}
