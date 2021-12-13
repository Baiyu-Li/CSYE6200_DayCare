package Model.Person;

import Model.Organization.Course;

public class Teacher extends Person {
    public static String PIdentity = "T";
    public Teacher(String lName, String fName, String gender, int age, String id, Course course) {
        super(lName, fName, gender, age, id, course);
    }

    public Teacher() {
        super();
    }
}