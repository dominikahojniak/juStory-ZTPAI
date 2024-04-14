package com.justory.backend.controller;
import com.justory.backend.api.external.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@NoArgsConstructor
    public class BooksController {
    @GetMapping("/{id}")
    public BooksDTO getBook(@PathVariable Integer id) {
        return new BooksDTO()
                .setId(id)
                .setTitle("Sample Title")
                .setAuthor("Sample Author")
                .setDescription("Sample description")
                .setISBN("123456789")
                .setDate(LocalDate.of(2023, 8, 30))
                .setImg("Sample img");
    }
    @GetMapping
    public List<BooksDTO> getAllBooks() {
        return List.of(
                new BooksDTO()
                        .setId(1)
                        .setTitle("Sample Title")
                        .setAuthor("Sample Author")
                        .setDescription("Sample description")
                        .setISBN("123456789")
                        .setDate(LocalDate.of(2023, 8, 30))
                        .setImg("Sample img")
        );
    }

}

