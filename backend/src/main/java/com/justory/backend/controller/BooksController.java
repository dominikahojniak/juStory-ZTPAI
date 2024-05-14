package com.justory.backend.controller;

import com.justory.backend.api.external.BooksDTO;
import com.justory.backend.service.BookService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDate;
import java.io.IOException;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
    public class BooksController {

    private final BookService bookService;

    @GetMapping("/{id}")
    public BooksDTO getBook(@PathVariable Integer id) {
        return bookService.getBookById(id);
    }

    @GetMapping
    public List<BooksDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/add")
    public ResponseEntity<BooksDTO> addBook(@RequestParam("file") MultipartFile file, @ModelAttribute BooksDTO bookDTO) {
        BooksDTO addedBook = bookService.addBook(bookDTO, file);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedBook);
    }
    @GetMapping("/premieres")
    public List<BooksDTO> getPremieresForCurrentMonth() {
        // Pobierz aktualną datę
        LocalDate currentDate = LocalDate.now();
        // Utwórz obiekt YearMonth na podstawie aktualnej daty
        YearMonth currentYearMonth = YearMonth.from(currentDate);
        // Pobierz książki z bieżącego miesiąca
        List<BooksDTO> allBooks = bookService.getAllBooks();
        // Wybierz tylko te książki, których data premiery jest w bieżącym miesiącu
        List<BooksDTO> premieresForCurrentMonth = allBooks.stream()
                .filter(book -> {
                    YearMonth premiereYearMonth = YearMonth.from(book.getDate());
                    return premiereYearMonth.equals(currentYearMonth);
                })
                .collect(Collectors.toList());

        return premieresForCurrentMonth;
    }
}

