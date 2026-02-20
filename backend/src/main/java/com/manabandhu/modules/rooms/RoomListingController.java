package com.manabandhu.modules.rooms;

import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rooms")
public class RoomListingController {

    private final RoomListingService roomListingService;

    public RoomListingController(RoomListingService roomListingService) {
        this.roomListingService = roomListingService;
    }

    @GetMapping
    public List<RoomListing> find(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) Integer maxRent,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate availableFrom
    ) {
        return roomListingService.find(city, maxRent, availableFrom);
    }

    @PostMapping
    public RoomListing create(@Valid @RequestBody CreateRoomListingRequest request) {
        return roomListingService.create(request);
    }
}
