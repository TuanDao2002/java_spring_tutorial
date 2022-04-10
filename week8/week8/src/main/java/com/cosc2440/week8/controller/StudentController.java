package com.cosc2440.week8.controller;

import com.cosc2440.week8.model.Student;
import com.cosc2440.week8.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(path = "/students", method = RequestMethod.GET)
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping(path = "/students", method = RequestMethod.POST)
    public int addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @RequestMapping(path = "/students/findID", method = RequestMethod.GET) // cannot have the same path "students" as get all method
    public Student getStudentById(@RequestParam("id") int id) {
        return studentService.getStudentById(id);
    }

    @RequestMapping(path = "/students/findName", method = RequestMethod.GET)
    public List<Student> getStudentByName(@RequestParam("name") String name) {
        return studentService.getStudentByName(name);
    }

    @RequestMapping(path = "/students", method = RequestMethod.PUT)
    public String updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @RequestMapping(path = "/students/{id}", method = RequestMethod.DELETE)
    public String deleteStudent(@PathVariable("id") int id) {
        return studentService.deleteStudentById(id);
    }

    @RequestMapping("*")
    public String warning() {
        return "404 not found!!!";
    }
}
