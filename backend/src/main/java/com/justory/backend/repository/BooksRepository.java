package com.justory.backend.repository;

import com.justory.backend.api.internal.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface BooksRepository extends JpaRepository<Books, Integer> {
    List<Books> findByTitleContainingOrAuthorContaining(String title, String author);
}
