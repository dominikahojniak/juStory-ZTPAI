package com.justory.backend.controller;

import com.justory.backend.api.external.BookFormatsDTO;
import com.justory.backend.service.BookFormatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/formats")
public class BookFormatsController {
    private final BookFormatsService bookFormatsService;
    @GetMapping
    public List<BookFormatsDTO> getFormats() {
     return bookFormatsService.getAllFormats();
    }
}
