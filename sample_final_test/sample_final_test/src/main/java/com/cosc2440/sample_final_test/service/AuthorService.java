package com.cosc2440.sample_final_test.service;

import com.cosc2440.sample_final_test.model.Author;
import com.cosc2440.sample_final_test.model.Library;
import com.cosc2440.sample_final_test.repository.AuthorRepository;
import com.cosc2440.sample_final_test.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private LibraryRepository libraryRepository;

    public AuthorService(){}

    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void setLibraryRepository(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public Author add(Author author) throws Exception {
        Optional<Library> findLibrary = libraryRepository.findById(author.getLibraryID());
        if (findLibrary.isEmpty()) throw new Exception("Library is not found for this author!!!");

        Author newAuthor = authorRepository.save(author);
        findLibrary.get().getAuthorList().add(newAuthor);
        return newAuthor;
    }

    public List<Author> search(String name, String credential, String order) {
        List<Author> authors;
        if (order != null && order.equalsIgnoreCase("desc")) {
            authors = authorRepository.findAllByOrderByIdDesc();
        } else {
            authors = authorRepository.findAllByOrderByIdAsc();
        }

        if (name != null) {
            authors.removeIf(author -> !author.getName().equalsIgnoreCase(name));
        }

        if (credential != null) {
            authors.removeIf(author -> !author.getCredential().equalsIgnoreCase(credential));
        }

        return authors;
    }

    public List<Author> get(String name, String credential, String order) {
        return search(name, credential, order);
    }

    public Author update(Author author) throws Exception {
        Optional<Author> findAuthor = authorRepository.findById(author.getId());
        if (findAuthor.isEmpty()) throw new Exception("Author not found!!!");
        Author updateAuthor = findAuthor.get();
        if (author.getName() != null) updateAuthor.setName(author.getName());
        if (author.getCredential() != null) updateAuthor.setCredential(author.getCredential());
        return updateAuthor;
    }

    public HttpStatus deleteById(Integer id) {
        Optional<Author> findAuthor = authorRepository.findById(id);
        if (findAuthor.isEmpty()) return HttpStatus.NOT_FOUND;
        authorRepository.deleteById(id);
        return HttpStatus.ACCEPTED;
    }
}
