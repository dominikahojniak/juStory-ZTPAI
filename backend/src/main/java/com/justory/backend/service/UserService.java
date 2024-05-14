package com.justory.backend.service;

import com.justory.backend.api.external.UsersDTO;
import com.justory.backend.api.internal.UserFeatures;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UsersDTO getUserById(Integer id);
    UsersDTO getUserByEmail(String email);
    UserFeatures getUserFeaturesByEmail(String email);
}
