package com.justory.backend.mapper;
import com.justory.backend.api.external.BooksDTO;
import com.justory.backend.api.internal.Books;
import org.springframework.stereotype.Component;
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
                .setImg(book.getImg());
    }
}
