package com.manabandhu.modules.rooms;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;

@Service
public class RoomListingService {

    private final AtomicLong idSequence = new AtomicLong(2);
    private final List<RoomListing> listings = new ArrayList<>(List.of(
            new RoomListing(1L, "Private room near downtown", "Dallas", "75201", 900, "Any", LocalDate.now().plusDays(10), List.of("Parking", "Laundry", "WiFi"), true),
            new RoomListing(2L, "Shared room for students", "Chicago", "60616", 650, "Female", LocalDate.now().plusDays(20), List.of("Gym", "Transit Nearby"), false)
    ));

    public List<RoomListing> find(String city, Integer maxRent, LocalDate availableFrom) {
        return listings.stream()
                .filter(item -> city == null || item.city().equalsIgnoreCase(city))
                .filter(item -> maxRent == null || item.rent() <= maxRent)
                .filter(item -> availableFrom == null || !item.availableFrom().isAfter(availableFrom))
                .toList();
    }

    public RoomListing create(CreateRoomListingRequest request) {
        RoomListing listing = new RoomListing(
                idSequence.incrementAndGet(),
                request.title(),
                request.city(),
                request.zip(),
                request.rent(),
                request.genderPreference() == null ? "Any" : request.genderPreference(),
                request.availableFrom(),
                request.amenities() == null ? List.of() : request.amenities(),
                false
        );
        listings.add(listing);
        return listing;
    }
}
