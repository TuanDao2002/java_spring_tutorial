package cosc2440.practice.courseManagementSystem.controller;

import cosc2440.practice.courseManagementSystem.model.Course;
import cosc2440.practice.courseManagementSystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping(path = "/courses", method = RequestMethod.POST)
    public String add(@RequestBody Course course) {
        return courseService.add(course);
    }

    @RequestMapping(path = "/courses", method = RequestMethod.GET)
    public List<Course> getALl() {
        return courseService.getAll();
    }

    @RequestMapping(path = "/courses", method = RequestMethod.PUT)
    public String update(@RequestBody Course course) {
        return courseService.update(course);
    }

    @RequestMapping(path = "/courses/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") int cid) {
        return courseService.delete(cid);
    }
}
