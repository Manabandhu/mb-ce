package com.manabandhu.modules.community;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateCommunityPostRequest(
        @NotBlank String city,
        @NotBlank String topic,
        @NotBlank String author,
        @NotBlank @Size(max = 500) String content
) {
}
