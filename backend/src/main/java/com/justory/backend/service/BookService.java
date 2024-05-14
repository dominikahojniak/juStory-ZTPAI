package com.justory.backend.service;

import com.justory.backend.api.external.BooksDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BookService {
    List<BooksDTO> getAllBooks();
    BooksDTO getBookById(Integer id);
    BooksDTO addBook(BooksDTO bookDTO, MultipartFile file);
    List<BooksDTO> searchBooks(String query);
}
