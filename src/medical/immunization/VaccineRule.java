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
    
    Map<String, Integer> requirements;
    
    VaccineRule(){
        requirements = new HashMap<>();
    }
    
    public void addRule(VaccineEnum v, Integer requiredCount){
        requirements.put(String.valueOf(v).toLowerCase(), requiredCount);
    }
    
    public int getDoseRequired(VaccineEnum v){
        
        if(!requirements.containsKey(String.valueOf(v).toLowerCase())){
            return 0;
        }
        
        return requirements.get(String.valueOf(v).toLowerCase());
    }
}
