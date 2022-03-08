package part2;

import java.util.ArrayList;

public class Student {
    private String studentID;
    private String name;
    private ArrayList<Course> courseList;

    public Student() {
        this.studentID = "s001";
        this.name = "default";
        this.courseList = new ArrayList<>();
    }

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.courseList = new ArrayList<>();
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void addCourse(Course course) {
        if (!courseList.contains(course)) {
            courseList.add(course);
        }
    }

    @Override
    public String toString() {
        return String.format("Student with ID: %s, name: %s", studentID, name);
    }
}
