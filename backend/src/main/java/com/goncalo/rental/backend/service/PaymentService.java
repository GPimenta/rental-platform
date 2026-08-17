package com.goncalo.rental.backend.service;

import com.goncalo.rental.backend.mapper.LeaseAgreementMapper;
import com.goncalo.rental.backend.mapper.PaymentMapper;
import com.goncalo.rental.backend.model.dto.request.PaymentRequest;
import com.goncalo.rental.backend.model.dto.request.PaymentStatusRequest;
import com.goncalo.rental.backend.model.dto.response.PaymentResponse;
import com.goncalo.rental.backend.model.entity.LeaseAgreement;
import com.goncalo.rental.backend.model.entity.Payment;
import com.goncalo.rental.backend.repository.LeaseAgreementRepository;
import com.goncalo.rental.backend.repository.PaymentRepository;
import com.goncalo.rental.backend.utils.PaymentStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final LeaseAgreementRepository leaseAgreementRepository;
    private final PaymentMapper paymentMapper;

    ///v1/lease-agreements/{leaseId}/payments
    public List<PaymentResponse> getListPayment(Long leaseId) {
        List<Payment> paymentsList = paymentRepository.findByLeaseAgreementId(leaseId);

        return paymentMapper.toListPaymentResponse(paymentsList);
    }

    ///v1/lease-agreements/{leaseId}/payments
    public PaymentResponse addPayment(Long leaseId, PaymentRequest paymentRequest) {
        LeaseAgreement leaseAgreement = leaseAgreementRepository.findById(leaseId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lease is not found"));

        Payment entity = paymentMapper.toEntity(paymentRequest);

        entity.setCurrentStatus(PaymentStatus.PENDING);
        entity.setLeaseAgreement(leaseAgreement);

        return paymentMapper.toPaymentResponse(paymentRepository.saveAndFlush(entity));
    }

    ///v1/payments/{id}/status
    public PaymentResponse updatePaymentSatus(Long id, PaymentStatusRequest paymentStatusRequest) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment does not exists"));

        if (payment.getCurrentStatus() != PaymentStatus.PENDING) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Cannot change payment status that is not PENDING");
        }
        if (paymentStatusRequest.getCurrentStatus() == PaymentStatus.PAID) {
            payment.setPaidAt(LocalDateTime.now());
        }
        payment.setCurrentStatus(paymentStatusRequest.getCurrentStatus());

        return paymentMapper.toPaymentResponse(paymentRepository.saveAndFlush(payment));
    }
}
