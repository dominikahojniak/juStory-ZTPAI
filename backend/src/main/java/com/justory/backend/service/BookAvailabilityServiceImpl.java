package com.justory.backend.service;

import com.justory.backend.api.external.BookFormatsDTO;
import com.justory.backend.api.external.BooksAvailabilityDTO;
import com.justory.backend.api.external.PlatformsDTO;
import com.justory.backend.api.internal.BookFormats;
import com.justory.backend.api.internal.Books;
import com.justory.backend.api.internal.BooksAvailability;
import com.justory.backend.api.internal.Platforms;
import com.justory.backend.mapper.BooksAvailabilityMapper;
import com.justory.backend.repository.BooksAvailabilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookAvailabilityServiceImpl implements BookAvailabilityService {

    private final BooksAvailabilityRepository booksAvailabilityRepository;
    private final BooksAvailabilityMapper booksAvailabilityMapper;
    private final PlatformsService platformsService;
    private final BookFormatsService bookFormatsService;

    public void addBookAvailability(Books book, List<PlatformsDTO> platforms, List<BookFormatsDTO> formats) {
        List<BooksAvailability> availabilities = new ArrayList<>();
        for (PlatformsDTO platformDTO : platforms) {
            Platforms platform = platformsService.getPlatformById(platformDTO.getId());
            for (BookFormatsDTO formatDTO : formats) {
                BookFormats format = bookFormatsService.getFormatById(formatDTO.getId());
                BooksAvailability availability = new BooksAvailability()
                        .setBook(book)
                        .setPlatform(platform)
                        .setFormat(format)
                        .setSubscriptionRequired(platformDTO.isSubscriptionRequired())
                        .setPurchaseOption(platformDTO.isPurchaseOption());
                availabilities.add(availability);
            }
        }
        booksAvailabilityRepository.saveAll(availabilities);
    }
    @Override
    public List<BooksAvailabilityDTO> getBookAvailabilityByBookId(Integer id) {
        List<BooksAvailability> availabilityList = booksAvailabilityRepository.findByBookId(id);
        return availabilityList.stream()
                .map(booksAvailabilityMapper::toDTO)
                .collect(Collectors.toList());
    }
}