package cosc2440.practice.courseManagementSystem.controller;

import cosc2440.practice.courseManagementSystem.model.CourseRegistration;
import cosc2440.practice.courseManagementSystem.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegistrationController {
    @Autowired
    public RegistrationService registrationService;

    @RequestMapping(path = "/registrations", method = RequestMethod.POST)
    public String add(@RequestParam("sid") int sid, @RequestParam("cid") int cid) {
        return registrationService.add(sid, cid);
    }

    @RequestMapping(path = "/registrations", method = RequestMethod.GET)
    public List<CourseRegistration> getAll() {
        return registrationService.getAll();
    }

    @RequestMapping(path = "/registrations/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long rid) {
        return registrationService.delete(rid);
    }
}
