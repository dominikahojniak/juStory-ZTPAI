package com.justory.backend.controller;

import com.justory.backend.api.external.BooksDTO;
import com.justory.backend.service.BookService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
    public class BooksController {

    private final BookService bookService;

    @GetMapping("/{id}")
    public BooksDTO getBook(@PathVariable Integer id) {
        return bookService.getBookById(id);
    }

    @GetMapping
    public List<BooksDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

}

