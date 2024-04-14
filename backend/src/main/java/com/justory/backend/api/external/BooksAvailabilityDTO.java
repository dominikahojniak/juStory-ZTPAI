package com.justory.backend.api.external;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class BooksAvailabilityDTO {
    private Integer id;
    private BooksDTO book;
    private PlatformsDTO platform;
    private BookFormatsDTO format;
    private boolean subscriptionRequired;
    private boolean purchaseOption;
}
