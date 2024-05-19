package com.justory.backend.service;

import com.justory.backend.api.external.BookFormatsDTO;
import com.justory.backend.api.external.BooksAvailabilityDTO;
import com.justory.backend.api.external.BooksDTO;
import com.justory.backend.api.external.PlatformsDTO;
import com.justory.backend.api.internal.Books;

import java.util.List;

public interface BookAvailabilityService {
    void addBookAvailability(Books book, List<PlatformsDTO> platforms, List<BookFormatsDTO> formats);
    List<BooksAvailabilityDTO> getBookAvailabilityByBookId(Integer id);
}
