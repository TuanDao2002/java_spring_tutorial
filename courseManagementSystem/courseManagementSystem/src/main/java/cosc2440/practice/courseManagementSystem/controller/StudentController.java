package cosc2440.practice.courseManagementSystem.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import cosc2440.practice.courseManagementSystem.model.Student;
import cosc2440.practice.courseManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class StudentController {
    private static final String datePattern = "MM/dd/yyyy";

    @Autowired
    private StudentService studentService;

    @RequestMapping(path = "/students", method = RequestMethod.POST)
    public String add(@RequestBody Student student) {
        return studentService.add(student);
    }

    // handle exception when date input has invalid format
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public String invalidDateFormat() {
        return "Invalid date format, must follow MM/dd/yyyy";
    }

    @RequestMapping(path = "/students", method = RequestMethod.GET)
    public List<Student> getAll(@RequestParam(value = "name", required = false) String name,
                                @RequestParam(value = "startDate", required = false) @JsonFormat(pattern = datePattern, timezone = "Asia/Ho_Chi_Minh") Date startDate,
                                @RequestParam(value = "endDate", required = false) @JsonFormat(pattern = datePattern, timezone = "Asia/Ho_Chi_Minh") Date endDate) {
        return studentService.getAll(name, startDate, endDate);
    }

    @RequestMapping(path = "/students_in_course/{cid}", method = RequestMethod.GET)
    public List<Student> getAllStudentsByCourseID(@PathVariable("cid") int cid) {
        return studentService.getAllStudent(cid);
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
