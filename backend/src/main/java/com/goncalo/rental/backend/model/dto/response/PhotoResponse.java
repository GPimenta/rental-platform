package com.goncalo.rental.backend.model.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PhotoResponse {
    private Long id;
    private Long propertyId;
    private Long userId;
    private String url;
    private String caption;
    private LocalDateTime createdAt;
}
