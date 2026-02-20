package com.manabandhu.modules.rides;

import java.time.LocalDate;
import java.time.LocalTime;

public record RideTrip(
        Long id,
        String fromCity,
        String toCity,
        LocalDate date,
        LocalTime departureTime,
        int seatsAvailable,
        int suggestedSplitAmount,
        String driverName
) {
}
