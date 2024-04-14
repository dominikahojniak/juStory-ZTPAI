package com.justory.backend.controller;

import com.justory.backend.api.external.BooksDTO;
import com.justory.backend.api.external.UserFeaturesDTO;
import com.justory.backend.api.external.UserToReadListDTO;
import com.justory.backend.api.external.UsersDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/toread")
public class UserToReadListController {
    @GetMapping
    public List<UserToReadListDTO> getUserToReadList() {
        return List.of(
                new UserToReadListDTO()
                        .setId(1)
                        .setUser(new UsersDTO())
                        .setBook(new BooksDTO().setId(1).setTitle("title").setAuthor("author").setDescription("description").setISBN("ISBN").setDate(LocalDate.of(2022,12,12)).setImg("img"))
                        .setDateAdded(LocalDate.of(2024,12,12))
        );
    }
}
