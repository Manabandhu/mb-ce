package com.manabandhu.modules.rides;

import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rides")
public class RideController {

    private final RideService rideService;

    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

    @GetMapping
    public List<RideTrip> find(
            @RequestParam(required = false) String fromCity,
            @RequestParam(required = false) String toCity,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        return rideService.find(fromCity, toCity, date);
    }

    @PostMapping
    public RideTrip create(@Valid @RequestBody CreateRideRequest request) {
        return rideService.create(request);
    }

    @PostMapping("/{rideId}/requests")
    public Map<String, Object> requestRide(@PathVariable Long rideId, @Valid @RequestBody RideRequestPayload payload) {
        return rideService.requestSeat(rideId, payload);
    }
}
