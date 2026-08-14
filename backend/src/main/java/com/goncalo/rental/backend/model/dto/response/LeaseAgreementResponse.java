package com.goncalo.rental.backend.model.dto.response;

import com.goncalo.rental.backend.utils.LeaseStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class LeaseAgreementResponse {
    private Long id;
    private Long userId;
    private Long unitId;
    private LocalDate startDate;
    private LocalDate endDate;
    private LeaseStatus leaseStatus;
    private BigDecimal rentAmount;
    private LocalDateTime createdAt;
}
