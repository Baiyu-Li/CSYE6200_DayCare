package edu.neu.csye6200;

public class Course {

	private int courseId;
	private String courseName;
	private String courseTeacher;


	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseTeacher() {
		return courseTeacher;
	}

	public void setCourseTeacher(String courseTeacher) {
		this.courseTeacher = courseTeacher;
	}

	public Course(int courseId, String courseName, String courseTeacher) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseTeacher = courseTeacher;
	}
}
