package part2;

import java.util.ArrayList;

public class Course {
    private String courseID;
    private String name;
    private ArrayList<Student> studentList;

    public Course() {
        this.courseID = "c001";
        this.name = "default";
        this.studentList = new ArrayList<>();
    }

    public Course(String courseID, String name) {
        this.courseID = courseID;
        this.name = name;
        this.studentList = new ArrayList<>();
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public boolean enroll(Student student) {
        if (studentList.contains(student)) {
            return false;
        }
        studentList.add(student);
        student.addCourse(this);
        return true;
    }

    @Override
    public String toString() {
        return String.format("Course with ID: %s, name: %s", courseID, name);
    }
}
