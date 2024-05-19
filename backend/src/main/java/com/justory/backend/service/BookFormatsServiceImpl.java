package com.justory.backend.service;

import com.justory.backend.api.external.BookFormatsDTO;
import com.justory.backend.api.internal.BookFormats;
import com.justory.backend.mapper.BookFormatsMapper;
import com.justory.backend.repository.BookFormatsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookFormatsServiceImpl implements BookFormatsService {

    private final BookFormatsRepository bookFormatsRepository;
    private final BookFormatsMapper bookFormatsMapper;

    @Override
    public BookFormats getFormatById(Integer id) {
        Optional<BookFormats> formatOptional = bookFormatsRepository.findById(id);
        return formatOptional.orElse(null);
    }

    @Override
    public List<BookFormatsDTO> getAllFormats() {
        List<BookFormats> formatsList = bookFormatsRepository.findAll();
        return formatsList.stream()
                .map(bookFormatsMapper::toDTO)
                .collect(Collectors.toList());
    }

}