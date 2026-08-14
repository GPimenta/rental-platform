package com.goncalo.rental.backend.model.dto.request;

import com.goncalo.rental.backend.utils.ApplicationStatus;
import com.goncalo.rental.backend.utils.LeaseStatus;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class LeaseAgreementRequest {

    @NotNull(message = "User Id is required")
    private Long userId;
    @NotNull(message = "Lease must have a start date")
    private LocalDate startDate;
    @NotNull(message = "Lease must have a end date")
    private LocalDate endDate;
    @NotNull(message = "Rent amount is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Must be greater than zero")
    private BigDecimal rentAmount;
    private LeaseStatus leaseStatus;
}
