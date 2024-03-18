package com.example.dz_try2.repository;

import com.example.dz_try2.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
