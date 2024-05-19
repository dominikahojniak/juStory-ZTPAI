package com.justory.backend.api.internal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Entity
@Table(name = "platforms")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Platforms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String img;
    private boolean subscriptionRequired; // Dodane pole
    private boolean purchaseOption;
}
