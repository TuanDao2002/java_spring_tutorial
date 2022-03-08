package part2;
public class EnrolmentSystem {
    public static void main(String[] args) {
        Student student1 = new Student("s37", "Jack");
        Student student2 = new Student("s38", "Jen");

        System.out.println(student1);
        System.out.println(student2);
        System.out.println();

        Course course1 = new Course("cosc23", "Web");
        Course course2 = new Course("cosc24", "Java");

        if (course1.enroll(student1)) {
            System.out.printf("%s has enrolled %s\n", student1, course1);
        } else {
            System.out.println("Already in there\n");
        }

        if (course2.enroll(student2)) {
            System.out.printf("%s has enrolled %s\n", student2, course2);
        } else {
            System.out.println("Already in there\n");
        }

        if (course2.enroll(student1)) {
            System.out.printf("%s has enrolled %s\n", student1, course2);
        } else {
            System.out.println("Already in there\n");
        }

        if (course1.enroll(student1)) {
            System.out.printf("%s has enrolled %s\n", student1, course1);
        } else {
            System.out.println("Already in there\n");
        }

        System.out.println(course1);
        System.out.println("Students in this course: " + course1.getStudentList());
        System.out.println();
        System.out.println(student1);
        System.out.println("Courses this student has enrolled: " + student1.getCourseList());
    }
}
