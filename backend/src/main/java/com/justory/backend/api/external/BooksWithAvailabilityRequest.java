package com.justory.backend.api.external;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BooksWithAvailabilityRequest {
    private BooksDTO bookDTO;
    private List<PlatformsDTO> platforms;
    private List<BookFormatsDTO> formats;
}