package com.manabandhu.modules.rides;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;

@Service
public class RideService {

    private final AtomicLong rideIdSequence = new AtomicLong(2);
    private final List<RideTrip> rides = new ArrayList<>(List.of(
            new RideTrip(1L, "Dallas", "Plano", LocalDate.now().plusDays(1), LocalTime.of(8, 15), 2, 8, "Nikhil"),
            new RideTrip(2L, "Chicago", "O'Hare Airport", LocalDate.now().plusDays(2), LocalTime.of(6, 45), 3, 15, "Priya")
    ));

    public List<RideTrip> find(String fromCity, String toCity, LocalDate date) {
        return rides.stream()
                .filter(ride -> fromCity == null || ride.fromCity().equalsIgnoreCase(fromCity))
                .filter(ride -> toCity == null || ride.toCity().equalsIgnoreCase(toCity))
                .filter(ride -> date == null || ride.date().equals(date))
                .toList();
    }

    public RideTrip create(CreateRideRequest request) {
        RideTrip ride = new RideTrip(
                rideIdSequence.incrementAndGet(),
                request.fromCity(),
                request.toCity(),
                request.date(),
                request.departureTime(),
                request.seatsAvailable(),
                request.suggestedSplitAmount(),
                request.driverName()
        );
        rides.add(ride);
        return ride;
    }

    public Map<String, Object> requestSeat(Long rideId, RideRequestPayload payload) {
        return Map.of(
                "rideId", rideId,
                "riderName", payload.riderName(),
                "status", "REQUESTED",
                "message", payload.message() == null ? "Interested in this ride" : payload.message()
        );
    }
}
