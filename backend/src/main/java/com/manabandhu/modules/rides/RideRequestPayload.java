package com.manabandhu.modules.rides;

import jakarta.validation.constraints.NotBlank;

public record RideRequestPayload(
        @NotBlank String riderName,
        String message
) {
}
