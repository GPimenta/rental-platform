package com.goncalo.rental.backend.repository;

import com.goncalo.rental.backend.model.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
