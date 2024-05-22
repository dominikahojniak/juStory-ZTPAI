package com.justory.backend.mapper;
import com.justory.backend.api.external.BooksDTO;
import com.justory.backend.api.external.CategoryDTO;
import com.justory.backend.api.internal.Books;
import com.justory.backend.api.internal.Category;
import com.justory.backend.service.FileUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

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
                .setImg(FileUtils.readFileFromLocation(book.getImg()))
                .setCategories(mapCategoriesToDTO(book.getCategories()));
    }
    private Set<CategoryDTO> mapCategoriesToDTO(Set<Category> categories) {
        if (categories == null) {
            return null;
        }
        return categories.stream()
                .map(category -> new CategoryDTO()
                        .setId(category.getId())
                        .setName(category.getName()))
                .collect(Collectors.toSet());
    }
}
