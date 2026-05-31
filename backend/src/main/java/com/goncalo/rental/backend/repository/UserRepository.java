package com.goncalo.rental.backend.repository;

import com.goncalo.rental.backend.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
