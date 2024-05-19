package com.justory.backend.service;

import com.justory.backend.api.external.BookFormatsDTO;
import com.justory.backend.api.internal.BookFormats;

import java.util.List;

public interface BookFormatsService {
    BookFormats getFormatById(Integer id);

    List<BookFormatsDTO> getAllFormats();
}
