package com.cosc2440.sample_final_test.controller;

import com.cosc2440.sample_final_test.model.Book;
import com.cosc2440.sample_final_test.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    public BookController(){};

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(path = "/book", method = RequestMethod.POST)
    public Book add(@RequestBody Book book) throws Exception {
        return bookService.add(book);
    }

    @RequestMapping(path = "/book", method = RequestMethod.GET)
    public List<Book> get(@RequestParam(value = "name", required = false) String name,
                          @RequestParam(value = "createdDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date createdDate,
                          @RequestParam(value = "order", required = false) String order) {
        return bookService.search(name, createdDate, order);
    }

    @RequestMapping(path = "/book", method = RequestMethod.PUT)
    public Book update(@RequestBody Book Book) throws Exception {
        return bookService.update(Book);
    }

    @RequestMapping(path = "/book/{id}", method = RequestMethod.DELETE)
    public HttpStatus deleteById(@PathVariable("id") Integer id) {
        return bookService.deleteById(id);
    }
}
