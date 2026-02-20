package com.manabandhu.modules.profiles;

import jakarta.validation.constraints.Size;
import java.util.List;

public record ProfileUpdateRequest(
        @Size(min = 2, max = 80) String fullName,
        @Size(max = 80) String city,
        List<String> languages,
        @Size(max = 80) String profession,
        @Size(max = 40) String visaStatus
) {
}
