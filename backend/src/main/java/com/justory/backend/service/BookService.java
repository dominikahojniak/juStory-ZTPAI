package com.justory.backend.service;

import com.justory.backend.api.external.BookFormatsDTO;
import com.justory.backend.api.external.BooksDTO;
import com.justory.backend.api.external.BooksWithAvailabilityRequest;
import com.justory.backend.api.external.PlatformsDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BookService {
    List<BooksDTO> getAllBooks();
    BooksDTO getBookById(Integer id);
    List<BooksDTO> searchBooks(String query);
    BooksDTO addBookWithAvailability(MultipartFile file, BooksWithAvailabilityRequest request);
}
