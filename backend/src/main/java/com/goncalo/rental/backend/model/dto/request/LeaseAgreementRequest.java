package com.goncalo.rental.backend.model.dto.request;

import com.goncalo.rental.backend.utils.ApplicationStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class LeaseAgreementRequest {
    private LocalDate startDate;
    private LocalDate endDate;
    private ApplicationStatus approvedContract;
}
