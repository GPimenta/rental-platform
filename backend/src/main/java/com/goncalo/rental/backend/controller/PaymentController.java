package com.goncalo.rental.backend.controller;

import com.goncalo.rental.backend.model.dto.request.PaymentRequest;
import com.goncalo.rental.backend.model.dto.request.PaymentStatusRequest;
import com.goncalo.rental.backend.model.dto.response.PaymentResponse;
import com.goncalo.rental.backend.service.PaymentService;
import jakarta.validation.Valid;
import jdk.jfr.BooleanFlag;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("/lease-agreements/{leaseId}/payments")
    public ResponseEntity<List<PaymentResponse>> getAllPayments(@PathVariable Long leaseId) {
        return ResponseEntity.ok(paymentService.getListPayment(leaseId));
    }

    @PostMapping("/lease-agreements/{leaseId}/payments")
    public ResponseEntity<PaymentResponse> addPayment(@PathVariable Long leaseId, @Valid @RequestBody PaymentRequest paymentRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.addPayment(leaseId, paymentRequest));
    }

    @PatchMapping("/payments/{id}/status")
    public ResponseEntity<PaymentResponse> updatePayment(@PathVariable Long id, @Valid @RequestBody PaymentStatusRequest paymentStatusRequest) {
        return ResponseEntity.ok(paymentService.updatePaymentSatus(id, paymentStatusRequest));
    }
}
