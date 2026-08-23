package com.goncalo.rental.backend.repository;

import com.goncalo.rental.backend.model.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
    List<Photo> findByPropertyId(Long propertyId);
    List<Photo> findByUnitId(Long unitId);
}
