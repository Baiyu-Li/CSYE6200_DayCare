/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medical.immunization;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Floyed
 */
public class VaccineCSVGenerator {
    
    
    /**
     * vaccine type and count is read in the following pattern 
     * 
     *    Hib,DTaP,Polio,HepatitisB,MMR,Varicella,Meningococcal
     * 
     *  Line 1: age 2-5
     *  Line 2: age 5-12
     *  Line 3: age 12-18
     *  Line 4: age 18-30
     * 
     *  Sample:
     *  4,4,3,3,1,1,0
     *  0,5,4,3,2,2,0
     *  0,1,4,3,2,2,1
     *  0,1,0,3,2,2,1
     *  
     */

    
    public void generateRuleFromSample(){
        
        String[] sampleInp = {"4,4,3,3,1,1,0",
                        "0,5,4,3,2,2,0",
                        "0,1,4,3,2,2,1",
                        "0,1,0,3,2,2,1"};

        List<String> inp = Arrays.asList(sampleInp);

        generateRules(inp);
        
    }
    
    public void generateRules(List<String> lines){
        
       VaccineRule rule2To5 = new VaccineRule();
       createRulesForGroupFromLine(rule2To5, lines.get(0));
       VaccineRules.addRuleForAgeRange(rule2To5, 2, 5);
       
       
       VaccineRule rule5To12 = new VaccineRule();
       createRulesForGroupFromLine(rule5To12, lines.get(1));
       VaccineRules.addRuleForAgeRange(rule5To12, 5, 12);
       

       VaccineRule rule12To18 = new VaccineRule();
       createRulesForGroupFromLine(rule12To18, lines.get(2));
       VaccineRules.addRuleForAgeRange(rule12To18, 12, 18);
       
       
       VaccineRule rule18To30 = new VaccineRule();
       createRulesForGroupFromLine(rule18To30, lines.get(3));
       VaccineRules.addRuleForAgeRange(rule18To30, 18, 30);
        
    }
    
    public void createRulesForGroupFromLine(VaccineRule rules, String line){
        
        String[] split = line.split(",");
        
        if(!split[0].equals("0")){
            rules.addRule(VaccineEnum.Hib, Integer.valueOf(split[0]));
        }
        
        if(!split[1].equals("0")){
            rules.addRule(VaccineEnum.DTaP, Integer.valueOf(split[1]));
        }
        
        if(!split[2].equals("0")){
            rules.addRule(VaccineEnum.Polio, Integer.valueOf(split[2]));
        }
        
        if(!split[3].equals("0")){
            rules.addRule(VaccineEnum.HepatitisB, Integer.valueOf(split[3]));
        }
        
        if(!split[4].equals("0")){
            rules.addRule(VaccineEnum.MMR, Integer.valueOf(split[4]));
        }
        
        if(!split[5].equals("0")){
            rules.addRule(VaccineEnum.Varicella, Integer.valueOf(split[5]));
        }
        if(!split[6].equals("0")){
            rules.addRule(VaccineEnum.Meningococcal, Integer.valueOf(split[6]));
        }
        
    }
    
    public static void main(String[] args) {
        VaccineCSVGenerator obj = new VaccineCSVGenerator();
        
        obj.generateRuleFromSample();
    }
    
}
