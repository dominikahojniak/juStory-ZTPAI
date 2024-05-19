package com.justory.backend.repository;

import com.justory.backend.api.external.PlatformsDTO;
import com.justory.backend.api.internal.Platforms;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlatformsRepository extends JpaRepository<Platforms, Integer> {

}