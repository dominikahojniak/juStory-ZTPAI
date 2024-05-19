package com.justory.backend.controller;

import com.justory.backend.api.external.BooksDTO;
import com.justory.backend.api.external.UserFeaturesDTO;
import com.justory.backend.api.external.UserToReadListDTO;
import com.justory.backend.api.external.UsersDTO;
import com.justory.backend.api.internal.Users;
import com.justory.backend.service.JwtService;
import com.justory.backend.service.UserService;
import com.justory.backend.service.UserToReadListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/toread")
public class UserToReadListController {

    private final UserToReadListService userToReadListService;
    private final JwtService jwtService;
    private final UserService userService;

    @Autowired
    public UserToReadListController(UserToReadListService userToReadListService, JwtService jwtService, UserService userService) {
        this.userToReadListService = userToReadListService;
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @PostMapping("/addbook/{bookId}")
    public ResponseEntity<?> addBookToUserToReadList(@PathVariable("bookId") Integer bookId, @RequestHeader("Authorization") String authorizationHeader) {
        try {
            Integer userId = getUserIdFromAuthorizationHeader(authorizationHeader);
            userToReadListService.addBookToUserToReadList(userId, bookId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            if (e.getMessage().contains("Book is already in the user's to-read list")) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding book to user's to-read list");
        }
    }

    private Integer getUserIdFromAuthorizationHeader(String authorizationHeader) throws Exception {
        String jwtToken = authorizationHeader.substring(7); // Usuń "Bearer " z nagłówka
        String userEmail = jwtService.extractEmail(jwtToken);
        UsersDTO user = userService.getUserByEmail(userEmail);
        if (user != null) {
            return user.getId();
        } else {
            throw new Exception("User not found for email: " + userEmail);
        }
    }
}