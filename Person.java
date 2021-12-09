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
public abstract class Person implements Comparable<Person> {
	private String id;

	private String lName;

	private String fName;

	private String gender;

	private int age;

	private Course course;


	@Override
	public int compareTo(Person person){
		Integer id1 = Integer.parseInt(this.id.substring(1));
		Integer id2 = Integer.parseInt(person.getId().substring(1));
		return id1.compareTo(id2);

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}



	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}


	@Override
	public String toString() {
		return "Person [lName=" + lName + ", fName=" + fName + ", gender=" + gender + ", age=" + age + ", id=" + id
			+ "]";
	}

	protected Person(String lName, String fName, String gender, int age, String id, Course course) {
		this.lName = lName;
		this.fName = fName;
		this.gender = gender;
		this.age = age;
		this.id = id;
		this.course = course;
	}

	protected Person() {

	}

}