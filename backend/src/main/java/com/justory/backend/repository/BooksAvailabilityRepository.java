package com.justory.backend.repository;

import com.justory.backend.api.internal.BooksAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooksAvailabilityRepository extends JpaRepository<BooksAvailability, Integer> {
    List<BooksAvailability> findByBookId(Integer bookId);
}
