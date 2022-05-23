package com.cosc2440.sample_final_test.repository;

import com.cosc2440.sample_final_test.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAllByOrderByIdAsc();
    List<Book> findAllByOrderByIdDesc();
}
