/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medical.immunization;

/**
 *
 * @author Floyed
 */
public class VaccineRules {
    
    /**
     * Lazy Singleton instance holds rule only till age 99 years for a single application
     */
    private static VaccineRule[] ageToRule;
    
    public static VaccineRule[] getInstance(){
        
        if(ageToRule == null){
            ageToRule = new VaccineRule[100];
        }
        
        return ageToRule;
    }
    
    public static void addRuleForAgeRange(VaccineRule rule, int fromAgeInYears, int toAgeInYears){
        
        if(fromAgeInYears < 0 || fromAgeInYears > 99){
            fromAgeInYears = 0;
        }
        
        if(toAgeInYears < 0 || toAgeInYears > 99){
            toAgeInYears = 99;
        }
        
        for(int i = fromAgeInYears ; i < toAgeInYears ; i ++){
           getInstance()[i] = rule;
        }
    }
    
    public static VaccineRule getRuleForAge(int ageInYears){
        
        if(ageInYears < 0 || ageInYears > 99){
            System.out.println("Error while adding rule for age: "+ ageInYears);
            return null;
        }
        
        return getInstance()[ageInYears];
    }
    
    
}
