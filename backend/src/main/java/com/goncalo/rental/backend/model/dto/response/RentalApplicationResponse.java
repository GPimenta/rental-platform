package com.goncalo.rental.backend.model.dto.response;

import com.goncalo.rental.backend.utils.ApplicationStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class RentalApplicationResponse {
    private Long id;
    private Long unitId;
    private String fullName;
    private ApplicationStatus currentStatus;
    private LocalDateTime createdAt;
}
