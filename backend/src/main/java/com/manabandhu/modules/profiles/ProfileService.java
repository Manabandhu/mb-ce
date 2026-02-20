package com.manabandhu.modules.profiles;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private Profile profile = new Profile(
            "demo-user-1",
            "Aarav Sharma",
            "Dallas",
            List.of("English", "Hindi", "Telugu"),
            "Software Engineer",
            "H1B",
            true
    );

    public Profile me() {
        return profile;
    }

    public Profile update(ProfileUpdateRequest request) {
        profile = new Profile(
                profile.userId(),
                request.fullName() == null ? profile.fullName() : request.fullName(),
                request.city() == null ? profile.city() : request.city(),
                request.languages() == null ? profile.languages() : request.languages(),
                request.profession() == null ? profile.profession() : request.profession(),
                request.visaStatus() == null ? profile.visaStatus() : request.visaStatus(),
                profile.profileVerified()
        );
        return profile;
    }
}
