package com.cosc2440.sample_final_test.controller;

import com.cosc2440.sample_final_test.model.Author;
import com.cosc2440.sample_final_test.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    public AuthorController(){}

    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping(path = "/author", method = RequestMethod.POST)
    public Author add(@RequestBody Author author) throws Exception {
        return authorService.add(author);
    }

    @RequestMapping(path = "/author", method = RequestMethod.GET)
    public List<Author> get(@RequestParam(value = "name", required = false) String name,
                             @RequestParam(value = "credential", required = false) String credential,
                             @RequestParam(value = "order", required = false) String order) {
        return authorService.get(name, credential, order);
    }

    @RequestMapping(path = "/author", method = RequestMethod.PUT)
    public Author update(@RequestBody Author author) throws Exception {
        return authorService.update(author);
    }

    @RequestMapping(path = "/author/{id}", method = RequestMethod.DELETE)
    public HttpStatus deleteById(@PathVariable("id") Integer id) {
        return authorService.deleteById(id);
    }
}
