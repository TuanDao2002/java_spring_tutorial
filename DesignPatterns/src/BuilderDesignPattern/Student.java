package BuilderDesignPattern;

public class Student {
    private final String studentID;
    private final String firstname;
    private final String lastname;
    private final String phone;
    private final String address;
    private final int age;
    private final String gender;

    private Student(StudentBuilder studentBuilder) {
        this.studentID = studentBuilder.studentID;
        this.firstname = studentBuilder.firstname;
        this.lastname = studentBuilder.lastname;
        this.phone = studentBuilder.phone;
        this.address = studentBuilder.address;
        this.age = studentBuilder.age;
        this.gender = studentBuilder.gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public static class StudentBuilder {
        private String studentID;
        private String firstname;
        private String lastname;
        private String phone;
        private String address;
        private int age;
        private String gender;

        public StudentBuilder(String studentID, String firstname, String lastname) {
            this.studentID = studentID;
            this.firstname = firstname;
            this.lastname = lastname;
        }

        public StudentBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public StudentBuilder address(String address) {
            this.address = address;
            return this;
        }

        public StudentBuilder age(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Student build() {
            Student student = new Student(this);
            if (!validateStudentObject(student)) {
                return null;
            }
            return student;
        }

        public boolean validateStudentObject(Student student) {
            if (student.studentID == null || student.firstname == null || student.lastname == null) {
                System.out.println("Missing student ID, firstname or lastname!!!");
                return false;
            }

            if (student.studentID.charAt(0) != 'S' && student.studentID.charAt(0) != 's' ) {
                System.out.println("Invalid student ID!!!");
                return false;
            }

            return true;
        }
    }
}
