/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medical.immunization;

import java.util.Date;

/**
 *
 * @author Floyed
 */
public class VaccineRecord {
    
    private String ID;
    private String studentId;
    private String vaccineName;
    private String vaccineId;
    private int vaccineCount;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getVaccineCount() {
        return vaccineCount;
    }

    public void setVaccineCount(int vaccineCount) {
        this.vaccineCount = vaccineCount;
    }
    private String lastDoseDate;    
    
//    private int Hib;
//    private int DTaP;
//    private int Polio;
//    private int HepatitisB;
//    private int MMR;
//    private int Varicella;
//    private int Meningococcal;
//
//    public int getHib() {
//        return Hib;
//    }
//
//    public void setHib(int Hib) {
//        this.Hib = Hib;
//    }
//
//    public int getDTaP() {
//        return DTaP;
//    }
//
//    public void setDTaP(int DTaP) {
//        this.DTaP = DTaP;
//    }
//
//    public int getPolio() {
//        return Polio;
//    }
//
//    public void setPolio(int Polio) {
//        this.Polio = Polio;
//    }
//
//    public int getHepatitisB() {
//        return HepatitisB;
//    }
//
//    public void setHepatitisB(int HepatitisB) {
//        this.HepatitisB = HepatitisB;
//    }
//
//    public int getMMR() {
//        return MMR;
//    }
//
//    public void setMMR(int MMR) {
//        this.MMR = MMR;
//    }
//
//    public int getVaricella() {
//        return Varicella;
//    }
//
//    public void setVaricella(int Varicella) {
//        this.Varicella = Varicella;
//    }
//
//    public int getMeningococcal() {
//        return Meningococcal;
//    }
//
//    public void setMeningococcal(int Meningococcal) {
//        this.Meningococcal = Meningococcal;
//    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(String vaccineId) {
        this.vaccineId = vaccineId;
    }

    public String getLastDoseDate() {
        return lastDoseDate;
    }

    public void setLastDoseDate(String lastDoseDate) {
        this.lastDoseDate = lastDoseDate;
    }
}
