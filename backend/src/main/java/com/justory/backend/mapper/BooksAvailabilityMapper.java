package com.justory.backend.mapper;

import com.justory.backend.api.external.BooksAvailabilityDTO;
import com.justory.backend.api.internal.BooksAvailability;
import org.springframework.stereotype.Component;

    @Component
    public class BooksAvailabilityMapper {
        public BooksAvailabilityDTO toDTO(BooksAvailability availability) {
            return new BooksAvailabilityDTO()
                    .setId(availability.getId())
                    .setBook(new BooksMapper().toDTO(availability.getBook()))
                    .setPlatform(new PlatformsMapper().toDTO(availability.getPlatform()))
                    .setFormat(new BookFormatsMapper().toDTO(availability.getFormat()))
                    .setSubscriptionRequired(availability.isSubscriptionRequired())
                    .setPurchaseOption(availability.isPurchaseOption());
        }
    }

