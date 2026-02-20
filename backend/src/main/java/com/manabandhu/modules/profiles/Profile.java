package com.manabandhu.modules.profiles;

import java.util.List;

public record Profile(
        String userId,
        String fullName,
        String city,
        List<String> languages,
        String profession,
        String visaStatus,
        boolean profileVerified
) {
}
