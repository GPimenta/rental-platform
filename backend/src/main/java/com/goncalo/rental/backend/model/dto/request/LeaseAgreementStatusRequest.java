package com.goncalo.rental.backend.model.dto.request;

import com.goncalo.rental.backend.utils.LeaseStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LeaseAgreementStatusRequest {
    @NotNull(message = "Status is required")
    private LeaseStatus leaseStatus;
}
