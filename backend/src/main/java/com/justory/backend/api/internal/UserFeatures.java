package com.justory.backend.api.internal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Entity
@Table(name="user_features")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserFeatures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long phone;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "userFeaturesId")
    private Users user;
}