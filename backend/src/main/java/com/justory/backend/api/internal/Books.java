package com.justory.backend.api.internal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name="books")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String author;
    private String description;
    private String ISBN;
    private LocalDate date;
    private String img;
}
