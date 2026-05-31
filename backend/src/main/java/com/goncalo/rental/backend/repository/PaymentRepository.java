package com.goncalo.rental.backend.repository;

import com.goncalo.rental.backend.model.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
