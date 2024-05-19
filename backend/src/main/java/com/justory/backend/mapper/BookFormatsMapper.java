package com.justory.backend.mapper;

import com.justory.backend.api.external.BookFormatsDTO;
import com.justory.backend.api.internal.BookFormats;
import com.justory.backend.service.FileUtils;
import org.springframework.stereotype.Component;

@Component
public class BookFormatsMapper {
    public BookFormatsDTO toDTO(BookFormats format) {
        return new BookFormatsDTO()
                .setId(format.getId())
                .setName(format.getName())
                .setImg(FileUtils.readFileFromLocation(format.getImg()));
    }
}