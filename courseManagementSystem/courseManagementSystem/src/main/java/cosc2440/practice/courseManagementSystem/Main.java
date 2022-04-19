package cosc2440.practice.courseManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// configure this so JpaRepository can be scanned
// the name of entityManagerFactory is sessionFactoryBean in AppConfig
@EnableJpaRepositories(basePackages = "cosc2440.practice.courseManagementSystem.repository", entityManagerFactoryRef = "sessionFactoryBean")
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
