package com.goncalo.rental.backend.repository;

import com.goncalo.rental.backend.model.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
