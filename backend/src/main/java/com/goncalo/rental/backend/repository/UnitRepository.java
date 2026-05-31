package com.goncalo.rental.backend.repository;

import com.goncalo.rental.backend.model.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<Unit, Long> {
}
