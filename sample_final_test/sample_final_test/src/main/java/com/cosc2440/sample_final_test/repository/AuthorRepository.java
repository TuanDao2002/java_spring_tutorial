package com.cosc2440.sample_final_test.repository;

import com.cosc2440.sample_final_test.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    List<Author> findAllByOrderByIdAsc();
    List<Author> findAllByOrderByIdDesc();
}
