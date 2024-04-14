package com.justory.backend.controller;

import com.justory.backend.api.external.BookFormatsDTO;
import com.justory.backend.api.external.BooksAvailabilityDTO;
import com.justory.backend.api.external.BooksDTO;
import com.justory.backend.api.external.PlatformsDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/availability")
public class BooksAvailabilityController {
    @GetMapping
    public List<BooksAvailabilityDTO> booksAvailability() {
        return List.of(
                new BooksAvailabilityDTO()
                        .setId(1)
                        .setBook(new BooksDTO())
                        .setPlatform(new PlatformsDTO())
                        .setFormat(new BookFormatsDTO())
                        .setSubscriptionRequired(true)
                        .setPurchaseOption(true)
        );
    }
}
