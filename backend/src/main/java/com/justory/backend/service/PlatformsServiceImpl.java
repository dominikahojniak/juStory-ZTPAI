package com.justory.backend.service;

import com.justory.backend.api.external.PlatformsDTO;
import com.justory.backend.api.internal.Platforms;
import com.justory.backend.mapper.PlatformsMapper;
import com.justory.backend.repository.PlatformsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PlatformsServiceImpl implements PlatformsService {

    private final PlatformsRepository platformsRepository;
    private final PlatformsMapper platformsMapper;

    @Override
    public Platforms getPlatformById(Integer id) {
        Optional<Platforms> platformOptional = platformsRepository.findById(id);
        return platformOptional.orElse(null);
    }

    @Override
    public List<PlatformsDTO> getAllPlatforms() {
        List<Platforms> platformsList = platformsRepository.findAll();
        return platformsList.stream()
                .map(platformsMapper::toDTO)
                .collect(Collectors.toList());
    }

}