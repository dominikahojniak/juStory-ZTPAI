package com.justory.backend.controller;

import com.justory.backend.api.external.PlatformsDTO;
import com.justory.backend.service.PlatformsService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/platforms")
public class PlatformsController {
    private final PlatformsService platformsService;
    @GetMapping
    public List<PlatformsDTO> getAllPlatforms() {
        return platformsService.getAllPlatforms();
    }

}

