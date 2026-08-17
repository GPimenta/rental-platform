package com.goncalo.rental.backend.repository;

import com.goncalo.rental.backend.model.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByLeaseAgreementId(Long leaseId);
}
