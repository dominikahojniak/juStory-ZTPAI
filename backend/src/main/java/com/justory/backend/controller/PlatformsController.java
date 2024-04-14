package com.justory.backend.controller;

import com.justory.backend.api.external.PlatformsDTO;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/platforms")
@NoArgsConstructor
public class PlatformsController {
    @GetMapping
    public List<PlatformsDTO> getAllPlatforms() {
        return List.of(
                new PlatformsDTO()
                        .setId(1)
                        .setName("Sample Name")
                        .setImg("Sample Img")
        );
    }

}

