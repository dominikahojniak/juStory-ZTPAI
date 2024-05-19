package com.justory.backend.service;

import com.justory.backend.api.external.PlatformsDTO;
import com.justory.backend.api.internal.Platforms;

import java.util.List;

public interface PlatformsService {
    Platforms getPlatformById(Integer id);

    List<PlatformsDTO> getAllPlatforms();
}
