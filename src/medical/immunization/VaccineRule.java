/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medical.immunization;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author whilm
 */
public class VaccineRule {
    
    Map<VaccineEnum, Integer> requirements;
    
    VaccineRule(){
        requirements = new HashMap<>();
    }
    
    public void addRule(VaccineEnum v, Integer requiredCount){
        requirements.put(v, requiredCount);
    }
    
    public int getDoseRequired(VaccineEnum v){
        return requirements.get(v);
    }
}
