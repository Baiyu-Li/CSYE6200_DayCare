/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Person;

import Model.Organization.Course;
import Model.Organization.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lynn Wei
 */

public class Student extends Person {
    public static String PIdentity = "S";

    private String fatherName;
    private String motherName;
    private String phone;
    private String address;
    private Subject subject;
    private String entryYear;

    public Student(String lName, String fName, String gender, int age, String id, String fatherName, String motherName, String entryYear,
                   String phone, String address, Subject subject, Course course) {
        super(lName, fName, gender, age, id, course);
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.phone = phone;
        this.address = address;
        this.subject = subject;
        this.entryYear = entryYear;
    }

    public Student() {
    }

    public static int compareById(Student s1, Student s2) {
        int i = Integer.parseInt(s1.getId().substring(1));
        int i2 = Integer.parseInt(s2.getId().substring(1));
        return i - i2;
    }

    public static int compareByGender(Student s1, Student s2) {
        return s1.getGender().compareTo(s2.getGender());
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getEntryYear() {
        return entryYear;
    }

    public void setEntryYear(String entryYear) {
        this.entryYear = entryYear;
    }


    @Override
    public String toString() {
        return "Student [fatherName=" + fatherName + ", motherName=" + motherName + "]";
    }

}

