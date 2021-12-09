/*
	* To change this license header, choose License Headers in Project Properties.
	* To change this template file, choose Tools | Templates
	* and open the template in the editor.
	*/
	package edu.neu.csye6200;

/**
 *
 * @author Lynn Wei
 */
	public class Student extends Person {

	private String fatherName;
	private String motherName;
	private String phone;
	private String address;

	public Student(String lName, String fName, String gender, int age, String id, String fatherName, String motherName,
	String phone, String address, Course course) {
	super(lName, fName, gender, age, id,course);
	this.fatherName = fatherName;
	this.motherName = motherName;
	this.phone = phone;
	this.address = address;
	}

	public Student() {
	}

	public static int compareById(Student s1, Student s2){
	StringBuilder sb1 = new StringBuilder();
	int i = Integer.parseInt(sb1.append(s1.getId().substring(1)).toString());
	StringBuilder sb2 = new StringBuilder();
	int i2 = Integer.parseInt(sb2.append(s2.getId().substring(1)).toString());
	return i - i2;
	}

	public static int compareByGender(Student s1, Student s2){
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

	@Override
	public String toString() {
	return "Student [fatherName=" + fatherName + ", motherName=" + motherName +"]";
	}

	}