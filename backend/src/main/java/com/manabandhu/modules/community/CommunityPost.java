package com.manabandhu.modules.community;

import java.time.Instant;

public record CommunityPost(
        Long id,
        String city,
        String topic,
        String author,
        String content,
        int upvotes,
        Instant createdAt
) {
}
