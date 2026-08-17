package com.goncalo.rental.backend.model.dto.request;

import com.goncalo.rental.backend.utils.PaymentStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PaymentStatusRequest {
    @NotNull(message = "Payment status is required")
    private PaymentStatus currentStatus;
}
