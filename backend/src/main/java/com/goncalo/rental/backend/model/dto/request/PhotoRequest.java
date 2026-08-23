package com.goncalo.rental.backend.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PhotoRequest {
    @NotBlank(message = "url is required!")
    @Size(max = 100, message = "Must not exceed 100 chars")
    private String url;
    @NotBlank(message = "Caption is required!")
    @Size(max = 100, message = "Must not exceed 100 chars")
    private String caption;
}
