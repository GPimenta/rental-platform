package com.goncalo.rental.backend.repository;

import com.goncalo.rental.backend.model.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findLeaseById(Long leaseId);
}
