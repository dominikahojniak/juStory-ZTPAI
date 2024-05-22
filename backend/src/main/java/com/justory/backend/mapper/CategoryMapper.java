package com.justory.backend.mapper;

import com.justory.backend.api.external.CategoryDTO;
import com.justory.backend.api.internal.Category;

public class CategoryMapper {
    public static CategoryDTO toDTO(Category category) {
        if (category == null) {
            return null;
        }
        return new CategoryDTO()
                .setId(category.getId())
                .setName(category.getName());
    }
}
