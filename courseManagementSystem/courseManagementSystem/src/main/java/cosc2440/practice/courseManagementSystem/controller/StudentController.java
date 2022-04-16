package cosc2440.practice.courseManagementSystem.controller;

import cosc2440.practice.courseManagementSystem.model.Student;
import cosc2440.practice.courseManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class StudentController {
    private static final String datePattern = "MM/dd/yyyy";

    @Autowired
    private StudentService studentService;

    @RequestMapping(path = "/students", method = RequestMethod.POST)
    public String add(@RequestParam("name") String name, @RequestParam("birthdate") @DateTimeFormat(pattern = datePattern) Date date) {
        return studentService.add(new Student(name, date));
    }

    @RequestMapping(path = "/students", method = RequestMethod.GET)
    public List<Student> getALl() {
        return studentService.getAll();
    }

    @RequestMapping(path = "/students", method = RequestMethod.PUT)
    public String update(@RequestBody Student student) {
        return studentService.update(student);
    }

    @RequestMapping(path = "/students/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") String sid) {
        return studentService.delete(sid);
    }
}
