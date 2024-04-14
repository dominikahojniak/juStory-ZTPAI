package com.justory.backend.controller;

import com.justory.backend.api.external.BookFormatsDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/formats")
public class BookFormatsController {
    @GetMapping
    public List<BookFormatsDTO> getFormats() {
        return List.of(
                new BookFormatsDTO()
                        .setId(1)
                        .setName("Sample Name")
                        .setImg("Sample Image")
        );
    }
}
