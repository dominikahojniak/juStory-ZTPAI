package com.justory.backend.service;

import com.justory.backend.api.internal.Books;
import com.justory.backend.api.external.BooksDTO;
import com.justory.backend.mapper.BooksMapper;
import com.justory.backend.repository.BooksRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BooksRepository booksRepository;
    private final BooksMapper booksMapper;
    private final FileStorageService fileStorageService;

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
    @Override
    public BooksDTO addBook(BooksDTO bookDTO, MultipartFile file) {
        String filePath = fileStorageService.saveFile(file, bookDTO.getId());
        Books book = new Books();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setDescription(bookDTO.getDescription());
        book.setISBN(bookDTO.getISBN());
        book.setDate(bookDTO.getDate());
        book.setImg(filePath);
        Books savedBook = booksRepository.save(book);
        return booksMapper.toDTO(savedBook);
    }
    @Override
    public List<BooksDTO> searchBooks(String query) {
        List<Books> searchResults = booksRepository.findByTitleContainingOrAuthorContaining(query, query);
        return searchResults.stream()
                .map(booksMapper::toDTO)
                .collect(Collectors.toList());
    }
}
