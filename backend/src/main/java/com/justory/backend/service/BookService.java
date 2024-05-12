package com.justory.backend.service;

import com.justory.backend.api.external.BooksDTO;

import java.util.List;

public interface BookService {
    List<BooksDTO> getAllBooks();
    BooksDTO getBookById(Integer id);
}
