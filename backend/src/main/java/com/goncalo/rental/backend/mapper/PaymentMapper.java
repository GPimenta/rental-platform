package com.goncalo.rental.backend.mapper;
import com.goncalo.rental.backend.model.dto.request.PaymentRequest;
import com.goncalo.rental.backend.model.dto.response.PaymentResponse;
import com.goncalo.rental.backend.model.entity.Payment;
import com.goncalo.rental.backend.model.entity.RentalApplication;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentResponse toPaymentResponse(Payment payment);
    Payment toEntity(PaymentRequest paymentRequest);
}
