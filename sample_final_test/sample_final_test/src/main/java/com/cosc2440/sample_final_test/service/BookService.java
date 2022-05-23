package com.cosc2440.sample_final_test.service;

import com.cosc2440.sample_final_test.model.Author;
import com.cosc2440.sample_final_test.model.Book;
import com.cosc2440.sample_final_test.model.Library;
import com.cosc2440.sample_final_test.repository.AuthorRepository;
import com.cosc2440.sample_final_test.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Book add(Book book) throws Exception {
        Optional<Author> findAuthor = authorRepository.findById(book.getAuthor().getId());
        if (findAuthor.isEmpty()) throw new Exception("Author is not found!!!");
        book.setAuthor(findAuthor.get());
        return bookRepository.save(book);
    }

    public List<Book> search(String name, Date createdDate, String order) {
        List<Book> books;
        if (order != null && order.equalsIgnoreCase("desc")) {
            books = bookRepository.findAllByOrderByIdDesc();
        } else {
            books = bookRepository.findAllByOrderByIdAsc();
        }

        if (name != null) {
            books.removeIf(book -> !book.getName().equalsIgnoreCase(name));
        }

        if (createdDate != null) {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            books.removeIf(book -> !fmt.format(book.getCreatedDate()).equals(fmt.format(createdDate)));
        }

        return books;
    }

    public List<Book> get(String name, Date createdDate, String order) {
        return search(name, createdDate, order);
    }

    public Book update(Book book) throws Exception {
        Optional<Book> findBook = bookRepository.findById(book.getId());
        if (findBook.isEmpty()) throw new Exception("Book is not found!!!");
        Book updateBook = findBook.get();
        if (book.getName() != null) updateBook.setName(book.getName());
        if (book.getCreatedDate() != null) updateBook.setCreatedDate(book.getCreatedDate());
        return updateBook;
    }

    public HttpStatus deleteById(Integer id) {
        Optional<Book> findBook = bookRepository.findById(id);
        if (findBook.isEmpty()) return HttpStatus.NOT_FOUND;
        bookRepository.deleteById(id);
        return HttpStatus.ACCEPTED;
    }
}
