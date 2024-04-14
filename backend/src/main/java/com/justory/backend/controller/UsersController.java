package com.justory.backend.controller;

import com.justory.backend.api.external.UserFeaturesDTO;
import com.justory.backend.api.external.UsersDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    @GetMapping
    public List<UsersDTO> getUsers() {
        return List.of(
                new UsersDTO()
                        .setId(1)
                        .setEmail("Sample email")
                        .setName("Sample Name")
                        .setUserFeaturesId(new UserFeaturesDTO().setId(1).setPhone(1234567890L))
                        .setRole("user")
        );
    }
}
