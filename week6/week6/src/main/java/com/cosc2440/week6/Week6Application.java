package com.cosc2440.week6;

import com.cosc2440.week6.config.AppConfig;
import com.cosc2440.week6.entity.Course;
import com.cosc2440.week6.entity.Person;
import com.cosc2440.week6.entity.Student;
import com.cosc2440.week6.service.CourseService;
import com.cosc2440.week6.service.PersonService;
import com.cosc2440.week6.service.StudentService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class Week6Application {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		/*
		PersonService personService = context.getBean(PersonService.class);

		// test save
		Person person = new Person();
		person.setName("dao kha tuan");
		personService.savePerson(person);

		// test get person by ID
		Person getPreviousPerson = personService.getPersonById(1);

		if (Objects.equals(person.toString(), getPreviousPerson.toString())){
			System.out.println("Can get person by ID");
		}

		// test update
		person.setName("new khatun");
		personService.update(person);
		System.out.println("Person after update:");
		System.out.println(person);

		// test get all
		Person person2 = new Person();
		person2.setName("tuan kha dao");
		personService.savePerson(person2);

		Person person3 = new Person();
		person3.setName("hello world");
		personService.savePerson(person3);

		List<Person> personList = personService.getAll();

		System.out.println("List of people:");
		for (Person p : personList) {
			System.out.println(p);
		}

		// test 3 methods of get person by name
		List<Person> matchedList;
		System.out.println("Get person by name");

		matchedList = personService.getPersonByName1("kha");
		System.out.println("With Criteria query:");
		System.out.println(matchedList);

		matchedList = personService.getPersonByName2("kha");
		System.out.println("With HQL query:");
		System.out.println(matchedList);

		matchedList = personService.getPersonByName3("kha");
		System.out.println("With SQL query:");
		System.out.println(matchedList);

		// test delete
		personService.delete(person2);
		personList = personService.getAll();
		System.out.println("List of people after delete:");
		for (Person p : personList) {
			System.out.println(p);
		}
		*/

		StudentService studentService = context.getBean(StudentService.class);
		CourseService courseService = context.getBean(CourseService.class);

		// save 2 students
		Student student1 = new Student();
		student1.setName("kha tuan");
		studentService.saveStudent(student1);

		Student student2 = new Student();
		student2.setName("tuan dao");
		studentService.saveStudent(student2);

		// save courses
		Course cosc3321 = new Course();
		cosc3321.setName("AI");
		cosc3321.setStudent(student1);
		courseService.saveCourse(cosc3321);

		Course cosc4030 = new Course();
		cosc4030.setName("Computation");
		cosc4030.setStudent(student1);
		courseService.saveCourse(cosc4030);

		Course cosc2440 = new Course();
		cosc2440.setName("SADI");
		cosc2440.setStudent(student2);
		courseService.saveCourse(cosc2440);

		// course list in POJO
		System.out.println("Course list in POJO student1:");
		System.out.println(student1.getCourseList());

		// course list in database
		System.out.println("Course list of student1 in database:");
		System.out.println(studentService.getStudentById(1).getCourseList());

		// after delete cosc3321, it will be removed in both student1 and database
		courseService.deleteCourse(cosc3321);
		List<Course> list1 = studentService.getStudentById(1).getCourseList();
		List<Course> courses = courseService.getAll();

		System.out.println("Course list of student1 in database after delete cosc3321:");
		System.out.println(list1);

		System.out.println("All courses in the database after delete cosc3321:");
		System.out.println(courses);

		// have to delete all courses of student1 before deleting student1 to prevent violating foreign key contraint
		courseService.deleteCourse(cosc4030);
		studentService.delete(student1);
		courses = courseService.getAll();

		System.out.println("All courses in the database after delete student1:");
		System.out.println(courses);
	}

}
