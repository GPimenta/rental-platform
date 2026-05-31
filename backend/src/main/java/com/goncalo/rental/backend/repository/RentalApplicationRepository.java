package com.goncalo.rental.backend.repository;

import com.goncalo.rental.backend.model.entity.RentalApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalApplicationRepository extends JpaRepository<RentalApplication, Long> {
}
