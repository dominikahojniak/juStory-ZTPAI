package com.justory.backend.api.internal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Entity
@Table(name = "book_availability")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class BooksAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Books book;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "platform_id")
    private Platforms platform;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "format_id")
    private BookFormats format;
    private boolean subscriptionRequired;
    private boolean purchaseOption;
}