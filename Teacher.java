/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200;

import java.util.List;

/**
 *
 * @author Lynn Wei
 */
public class Teacher extends Person {

	private StudentDirectory studentDirectory;

	public StudentDirectory getStudentDirectory(){
		return  studentDirectory;
	}

	public Teacher() {
		studentDirectory = new StudentDirectory();
	}

	public Teacher(String id, String lName, String fName, String gender, int age, Course course) {
		super(lName, fName, gender, age, id,course);
	}

	@Override
	public String toString() {
		return "Teacher:"+course.getCourseName();
	}

	public void addStudent(Student s){
		this.studentDirectory.addStudent(s);
	}

	public static int compareById(Teacher t1, Teacher t2){
		StringBuilder sb1 = new StringBuilder();
		int i1 = Integer.parseInt(sb1.append(t1.getId().substring(1)).toString());
		StringBuilder sb2 = new StringBuilder();
		int i2 = Integer.parseInt(sb2.append(t2.getId().substring(1)).toString());
		return i1 - i2;
	}

	public static int compareByLastName(Teacher t1, Teacher t2){
		return t1.getlName().compareTo(t2.getlName());
	}

}