package com.justory.backend.api.external;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class BooksDTO {
    private Integer id;
    private String title;
    private String author;
    private String description;
    private String ISBN;
    private LocalDate date;
    private byte[] img;
}
