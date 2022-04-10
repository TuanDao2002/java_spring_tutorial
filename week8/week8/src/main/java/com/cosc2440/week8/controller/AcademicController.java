package com.cosc2440.week8.controller;

import com.cosc2440.week8.model.Lecturer;
import com.cosc2440.week8.model.School;
import com.cosc2440.week8.service.AcademicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AcademicController {
    // to add new Lecturer, first add a School first, then add the Lecturer and the School of that Lecturer

    // Ex: add School object
    /*
        {
            "name": "rmit"
        }
    */

    // Then add Lecturer object
    /*
        {
            "name": "minh vu",
            "school": {
                "id": 1,
                "name": "rmit"
            }
        }
    */
    @Autowired
    private AcademicService academicService;

    @RequestMapping(path = "/schools", method = RequestMethod.POST)
    public int addSchool(@RequestBody School school) {
        return academicService.addSchool(school);
    }

    @RequestMapping(path = "/schools", method = RequestMethod.GET)
    public List<School> getAllSchools() {
        return academicService.getAllSchools();
    }

    @RequestMapping(path = "/lecturers", method = RequestMethod.POST)
    public String addLecturer(@RequestBody Lecturer lecturer) {
        return academicService.addLecturer(lecturer);
    }

    @RequestMapping(path = "/lecturers", method = RequestMethod.GET)
    public List<Lecturer> getAllLecturers() {
        return academicService.getAllLecturers();
    }
}
