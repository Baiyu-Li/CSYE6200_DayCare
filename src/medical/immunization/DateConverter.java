/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medical.immunization;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Floyed
 */
public class DateConverter {
    
    public static Date getDateFromString(String date){
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        Date convertedCurrentDate = null;
        try {
            convertedCurrentDate = sdf.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(DateConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return convertedCurrentDate;
    }
    
    public static String getStringFromDate(Date date){
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        String convertedCurrentDate = null;
        convertedCurrentDate = sdf.format(convertedCurrentDate);
        
        return convertedCurrentDate;
    }
}
