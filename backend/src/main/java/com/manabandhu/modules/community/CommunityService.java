package com.manabandhu.modules.community;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;

@Service
public class CommunityService {

    private final AtomicLong postIdSequence = new AtomicLong(2);
    private final List<CommunityPost> posts = new ArrayList<>(List.of(
            new CommunityPost(1L, "Dallas", "Housing", "Rohit", "Looking for a 2B2B roommate near Irving.", 12, Instant.now().minusSeconds(3600)),
            new CommunityPost(2L, "Chicago", "Immigration", "Ananya", "Sharing my STEM OPT extension checklist.", 19, Instant.now().minusSeconds(5000))
    ));

    public List<CommunityPost> list(String city, String topic) {
        return posts.stream()
                .filter(post -> city == null || post.city().equalsIgnoreCase(city))
                .filter(post -> topic == null || post.topic().equalsIgnoreCase(topic))
                .toList();
    }

    public CommunityPost create(CreateCommunityPostRequest request) {
        CommunityPost post = new CommunityPost(
                postIdSequence.incrementAndGet(),
                request.city(),
                request.topic(),
                request.author(),
                request.content(),
                0,
                Instant.now()
        );
        posts.add(0, post);
        return post;
    }
}
