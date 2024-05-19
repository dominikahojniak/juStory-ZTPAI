package com.justory.backend.repository;

import com.justory.backend.api.internal.BookFormats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookFormatsRepository extends JpaRepository<BookFormats, Integer> {

}