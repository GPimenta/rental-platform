package com.goncalo.rental.backend.mapper;
import com.goncalo.rental.backend.model.dto.request.PaymentRequest;
import com.goncalo.rental.backend.model.dto.request.PaymentStatusRequest;
import com.goncalo.rental.backend.model.dto.response.PaymentResponse;
import com.goncalo.rental.backend.model.entity.Payment;
import com.goncalo.rental.backend.model.entity.RentalApplication;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    @Mapping(target = "leaseId", source = "leaseAgreement.id")
    PaymentResponse toPaymentResponse(Payment payment);
    @Mapping(target = "leaseId", source = "leaseAgreement.id")
    List<PaymentResponse> toListPaymentResponse(List<Payment> payments);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "leaseAgreement", ignore = true)
    @Mapping(target = "paidAt", ignore = true)
    @Mapping(target = "currentStatus" , ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Payment toEntity(PaymentRequest paymentRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "leaseAgreement", ignore = true)
    @Mapping(target = "paidAt", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Payment toEntity(PaymentStatusRequest paymentStatusRequest);
}
