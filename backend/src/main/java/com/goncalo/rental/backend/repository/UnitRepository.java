package com.goncalo.rental.backend.repository;

import com.goncalo.rental.backend.model.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {
    List<Unit> findByPropertyId(Long propertyId);
}
