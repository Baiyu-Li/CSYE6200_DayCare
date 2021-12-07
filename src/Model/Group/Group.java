/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Group;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fuyanping
 */
public class Group extends AbstractGroup{
    private int gid;
    private int gCapacity;
    private int gType;
    
    private List<String> glist=new ArrayList<>();
    
    public Group(int id,int capacity,int type){
        this.gid=id;
        this.gCapacity=capacity;
        this.gType=type;
    }
    public int getGroupId(){
        return this.gid;
    }
    
    public void addPerson(String p){
        if(this.glist.size()<this.gCapacity&&!this.glist.contains(p)){
             this.glist.add(p);
        }
    }
    public void removePerson(String p){
        if(this.glist.size()>0&&this.glist.contains(p)){
        this.glist.remove(p);
        }
    }
    @Override
    public void showGroup(){
        
    }
}
