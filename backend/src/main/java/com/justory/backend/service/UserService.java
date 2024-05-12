package com.justory.backend.service;

import com.justory.backend.api.external.UsersDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UsersDTO getUserById(Integer id);
    UsersDTO getUserByEmail(String email);
}
