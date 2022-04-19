package cosc2440.practice.courseManagementSystem;

import cosc2440.practice.courseManagementSystem.repository.CourseRegistrationRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = CourseRegistrationRepository.class) // configure this so crudRepository can be scanned
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
