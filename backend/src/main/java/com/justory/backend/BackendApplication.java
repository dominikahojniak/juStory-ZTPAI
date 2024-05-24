package com.justory.backend;

import com.justory.backend.api.internal.Books;
import com.justory.backend.api.internal.UserFeatures;
import com.justory.backend.api.internal.Users;
import com.justory.backend.repository.BooksRepository;
import com.justory.backend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
    @Bean
    public CommandLineRunner init(
    ) {
        return args -> {
        };
    }
}
