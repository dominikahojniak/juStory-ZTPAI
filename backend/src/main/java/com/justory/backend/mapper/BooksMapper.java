package com.justory.backend.mapper;
import com.justory.backend.api.external.BooksDTO;
import com.justory.backend.api.internal.Books;
import com.justory.backend.service.FileUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BooksMapper {
    public BooksDTO toDTO(Books book) {
        return new BooksDTO()
                .setId(book.getId())
                .setTitle(book.getTitle())
                .setAuthor(book.getAuthor())
                .setDescription(book.getDescription())
                .setISBN(book.getISBN())
                .setDate(book.getDate())
                .setImg(FileUtils.readFileFromLocation(book.getImg())); // Ustawiamy pole img na null na potrzeby obsługi w przypadku braku obrazu w encji
    }

}
