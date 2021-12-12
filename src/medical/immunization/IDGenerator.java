/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medical.immunization;

import java.util.UUID;

/**
 *
 * @author Floyed
 */
public class IDGenerator {
    
    
    public static String getId(){
        return UUID.randomUUID().toString();
    }
}
