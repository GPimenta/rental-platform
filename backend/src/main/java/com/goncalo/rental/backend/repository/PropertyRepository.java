package com.goncalo.rental.backend.repository;

import com.goncalo.rental.backend.model.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
