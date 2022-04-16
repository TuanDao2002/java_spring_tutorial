package cosc2440.practice.courseManagementSystem.controller;

import cosc2440.practice.courseManagementSystem.model.Student;
import cosc2440.practice.courseManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(path = "/students", method = RequestMethod.POST)
    public String add(@RequestBody Student student) {
        return studentService.add(student);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public String invalidDateFormat() {
        return "Invalid date format, must follow MM/dd/yyyy";
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
    public String delete(@PathVariable("id") int sid) {
        return studentService.delete(sid);
    }
}
