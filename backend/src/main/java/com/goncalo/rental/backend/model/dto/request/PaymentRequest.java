package com.goncalo.rental.backend.model.dto.request;

import com.goncalo.rental.backend.model.entity.LeaseAgreement;
import com.goncalo.rental.backend.utils.PaymentStatus;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Must be greater than zero")
    private BigDecimal amount;
    @NotNull(message = "DueDate must have a date")
    private LocalDate dueDate;
}
