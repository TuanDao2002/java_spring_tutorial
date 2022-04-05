package com.cosc2440.week6;

import com.cosc2440.week6.config.AppConfig;
import com.cosc2440.week6.entity.Person;
import com.cosc2440.week6.service.PersonService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class Week6Application {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

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
	}

}
