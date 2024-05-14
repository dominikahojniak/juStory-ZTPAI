package com.justory.backend.controller;
import com.justory.backend.api.external.UserFeaturesDTO;
import com.justory.backend.api.external.UsersDTO;
import com.justory.backend.api.internal.UserFeatures;
import com.justory.backend.api.internal.Users;
import com.justory.backend.service.JwtService;
import com.justory.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private final UserService userService;
    private final JwtService jwtService;
    @Autowired
    public UsersController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersDTO> getUser(@PathVariable Integer id) {
        UsersDTO userDTO = userService.getUserById(id);
        return ResponseEntity.ok().body(userDTO);
    }
    @GetMapping("/profile")
    public ResponseEntity<UsersDTO> getUserProfile(Authentication authentication) {
        Users currentUser = (Users) authentication.getPrincipal();
        String userEmail = currentUser.getEmail();
        UsersDTO userDTO = userService.getUserByEmail(userEmail);
        if (userDTO != null) {
            UserFeatures userFeatures = userService.getUserFeaturesByEmail(userEmail); // Pobierz dane z tabeli user_features
            if (userFeatures != null) {
                UserFeaturesDTO userFeaturesDTO = new UserFeaturesDTO().setPhone(userFeatures.getPhone());
                userDTO.setUserFeaturesID(userFeaturesDTO);
            }
            return ResponseEntity.ok(userDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}