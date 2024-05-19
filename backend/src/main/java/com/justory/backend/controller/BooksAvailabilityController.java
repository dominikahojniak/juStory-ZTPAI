package com.justory.backend.controller;

import com.justory.backend.api.external.BookFormatsDTO;
import com.justory.backend.api.external.BooksAvailabilityDTO;
import com.justory.backend.api.external.BooksDTO;
import com.justory.backend.api.external.PlatformsDTO;
import com.justory.backend.service.BookAvailabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/availability")
public class BooksAvailabilityController {
    private final BookAvailabilityService bookAvailabilityService;
    @GetMapping("/{id}")
    public List<BooksAvailabilityDTO> getBookAvailability(@PathVariable Integer id) {
        return bookAvailabilityService.getBookAvailabilityByBookId(id);
    }
}
