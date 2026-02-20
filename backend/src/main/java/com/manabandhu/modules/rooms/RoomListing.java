package com.manabandhu.modules.rooms;

import java.time.LocalDate;
import java.util.List;

public record RoomListing(
        Long id,
        String title,
        String city,
        String zip,
        int rent,
        String genderPreference,
        LocalDate availableFrom,
        List<String> amenities,
        boolean verified
) {
}
