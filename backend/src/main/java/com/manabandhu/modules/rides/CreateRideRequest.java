package com.manabandhu.modules.rides;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

public record CreateRideRequest(
        @NotBlank String fromCity,
        @NotBlank String toCity,
        @NotNull LocalDate date,
        @NotNull LocalTime departureTime,
        @Min(1) @Max(8) int seatsAvailable,
        @Min(0) int suggestedSplitAmount,
        @NotBlank String driverName
) {
}
