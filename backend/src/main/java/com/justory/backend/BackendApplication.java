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
    public CommandLineRunner init( final BooksRepository booksRepository,
                                   final UserRepository userRepository
    ) {
        return args -> {
            Books book = new Books()
                    .setTitle("Sample Title")
                    .setAuthor("Sample Author")
                    .setDescription("Sample description")
                    .setISBN("123456789")
                    .setDate(LocalDate.of(2023, 8, 30))
                    .setImg("Sample img");
            Books book2 = new Books()
                    .setTitle("Sample Title2")
                    .setAuthor("Sample Author2")
                    .setDescription("Sample description2")
                    .setISBN("123456788")
                    .setDate(LocalDate.of(2023, 8, 12))
                    .setImg("Sample img2");
            booksRepository.save(book);
            booksRepository.save(book2);
            UserFeatures userFeatures = new UserFeatures()
                    .setPhone(1234567890L);
            Users user = new Users()
                    .setEmail("example@email.com")
                    .setName("Example Name")
                    .setPassword("examplePassword")
                    .setRole("user")
                    .setUserFeaturesID(userFeatures);
            userFeatures.setUser(user);
            userRepository.save(user);
        };
    }
}
