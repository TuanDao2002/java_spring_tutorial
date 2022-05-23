package com.cosc2440.sample_final_test.repository;

import com.cosc2440.sample_final_test.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibraryRepository extends JpaRepository<Library, Integer> {
    List<Library> findAllByOrderByIdAsc();
    List<Library> findAllByOrderByIdDesc();
}
