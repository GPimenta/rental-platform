package com.goncalo.rental.backend.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FeedbackRequest {
    @NotNull(message = "User id is required")
    private Long userId;
    @NotBlank(message = "Message is required!")
    @Size(max = 255, message = "Must not exceed 255 chars")
    private String message;
}
