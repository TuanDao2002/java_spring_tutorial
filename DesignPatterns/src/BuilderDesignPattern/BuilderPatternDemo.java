package BuilderDesignPattern;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        Student student1 = new Student.StudentBuilder("s3877347", "tuan", "dao")
                .phone("0908309768")
                .age(20)
                .address("binh tan, hcm")
                .gender("Male")
                .build();
        System.out.println(student1.toString());

        Student student2 = new Student.StudentBuilder("3877", "kha", "tuan").build();
        if (student2 == null) {
            System.out.println("student2's info is invalid!!!");
        }

        Student student3 = new Student.StudentBuilder("s3873234", "dao", "tuan")
                .age(20)
                .address("binh tan, hcm")
                .build();
        System.out.println(student3.toString());
    }
}
