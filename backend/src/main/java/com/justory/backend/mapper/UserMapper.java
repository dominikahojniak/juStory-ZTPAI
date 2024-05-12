package com.justory.backend.mapper;

import com.justory.backend.api.external.UserFeaturesDTO;
import com.justory.backend.api.external.UsersDTO;
import com.justory.backend.api.internal.UserFeatures;
import com.justory.backend.api.internal.Users;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UsersDTO toDTO(Users users) {
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setId(users.getId())
                .setEmail(users.getEmail())
                .setName(users.getName())
                .setRole(users.getRole());

        if (users.getUserFeaturesID() != null) {
            UserFeatures userFeatures = users.getUserFeaturesID();
            UserFeaturesDTO userFeaturesDTO = new UserFeaturesDTO();
            userFeaturesDTO.setId(userFeatures.getId())
                    .setPhone(userFeatures.getPhone());
            usersDTO.setUserFeaturesID(userFeaturesDTO);
        }

        return usersDTO;
    }

    public UserFeaturesDTO toDTO(UserFeatures userFeatures) {
        UserFeaturesDTO userFeaturesDTO = new UserFeaturesDTO();
        userFeaturesDTO.setId(userFeatures.getId())
                .setPhone(userFeatures.getPhone());

        return userFeaturesDTO;
    }
}