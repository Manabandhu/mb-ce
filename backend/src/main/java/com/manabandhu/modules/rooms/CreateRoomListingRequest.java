package com.manabandhu.modules.rooms;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public record CreateRoomListingRequest(
        @NotBlank String title,
        @NotBlank String city,
        @NotBlank String zip,
        @Min(100) @Max(10000) int rent,
        String genderPreference,
        @NotNull LocalDate availableFrom,
        List<String> amenities
) {
}
