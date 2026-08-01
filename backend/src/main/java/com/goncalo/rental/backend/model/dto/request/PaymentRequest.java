package com.goncalo.rental.backend.model.dto.request;

import com.goncalo.rental.backend.model.entity.LeaseAgreement;
import com.goncalo.rental.backend.utils.PaymentStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PaymentRequest {
    private LeaseAgreement leaseId;
    private BigDecimal amount;
    private LocalDate dueDate;
    private LocalDateTime paidAt;
    private PaymentStatus currentStatus;

}
