package com.manabandhu.modules.community;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/community/posts")
public class CommunityController {

    private final CommunityService communityService;

    public CommunityController(CommunityService communityService) {
        this.communityService = communityService;
    }

    @GetMapping
    public List<CommunityPost> list(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String topic
    ) {
        return communityService.list(city, topic);
    }

    @PostMapping
    public CommunityPost create(@Valid @RequestBody CreateCommunityPostRequest request) {
        return communityService.create(request);
    }
}
