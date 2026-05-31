package com.goncalo.rental.backend.repository;

import com.goncalo.rental.backend.model.entity.LeaseAgreement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaseAgreementRepository extends JpaRepository<LeaseAgreement, Long> {
}
