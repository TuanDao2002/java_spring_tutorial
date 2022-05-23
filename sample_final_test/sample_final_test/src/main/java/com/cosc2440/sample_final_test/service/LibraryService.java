package com.cosc2440.sample_final_test.service;

import com.cosc2440.sample_final_test.model.Library;
import com.cosc2440.sample_final_test.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;

    public LibraryService(){}

    public void setLibraryRepository(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public Library add(Library library) {
        return libraryRepository.save(library);
    }

    public List<Library> search(String subject, String order) {
        List<Library> libraries;
        if (order != null && order.equalsIgnoreCase("desc")) {
            libraries = libraryRepository.findAllByOrderByIdDesc();
        } else {
            libraries = libraryRepository.findAllByOrderByIdAsc();
        }

        if (subject != null) {
            libraries.removeIf(library -> !library.getSubject().equalsIgnoreCase(subject));
        }

        return libraries;
    }

    public List<Library> get(String subject, String order) {
        return search(subject, order);
    }

    public Library update(Library library) throws Exception {
        Optional<Library> findLibrary = libraryRepository.findById(library.getId());
        if (findLibrary.isEmpty()) throw new Exception("Library not found!!!");
        Library updateLibrary = findLibrary.get();
        if (library.getSubject() != null) updateLibrary.setSubject(library.getSubject());
        return updateLibrary;
    }
}
