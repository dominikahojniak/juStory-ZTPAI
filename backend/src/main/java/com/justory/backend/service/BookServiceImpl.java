package com.justory.backend.service;

import com.justory.backend.api.internal.Books;
import com.justory.backend.api.external.BooksDTO;
import com.justory.backend.mapper.BooksMapper;
import com.justory.backend.repository.BooksRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BooksRepository booksRepository;
    private final BooksMapper booksMapper;


    @Override
    public List<BooksDTO> getAllBooks() {
        List<Books> booksList = booksRepository.findAll();
        return booksList.stream()
                .map(booksMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BooksDTO getBookById(Integer id) {
        Optional<Books> booksOptional = booksRepository.findById(id);
        return booksOptional.map(booksMapper::toDTO).orElse(null);
    }
}
