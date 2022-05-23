package com.cosc2440.sample_final_test.controller;

import com.cosc2440.sample_final_test.model.Library;
import com.cosc2440.sample_final_test.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    public LibraryController(){}

    public void setLibraryService(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @RequestMapping(path = "/library", method = RequestMethod.POST)
    public Library add(@RequestBody Library library) {
        return libraryService.add(library);
    }

    @RequestMapping(path = "/library", method = RequestMethod.GET)
    public List<Library> get(@RequestParam(value = "subject", required = false) String subject,
                             @RequestParam(value = "order", required = false) String order) {
        return libraryService.search(subject, order);
    }

    @RequestMapping(path = "/library", method = RequestMethod.PUT)
    public Library update(@RequestBody Library library) throws Exception {
        return libraryService.update(library);
    }
}
