package com.goncalo.rental.backend.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PropertyRequest {
    @NotBlank(message = "Name is required!")
    @Size(max = 100, message = "Must not exceed 100 chars")
    private String name;
    @NotBlank(message = "Address is required!")
    @Size(max = 255, message = "Address must not exceed 255 characters")
    private String address;
    private String description;
}
