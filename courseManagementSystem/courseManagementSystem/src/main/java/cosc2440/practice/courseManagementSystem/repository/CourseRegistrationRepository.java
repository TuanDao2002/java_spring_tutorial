package cosc2440.practice.courseManagementSystem.repository;

import cosc2440.practice.courseManagementSystem.model.CourseRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration, Long> {

}
