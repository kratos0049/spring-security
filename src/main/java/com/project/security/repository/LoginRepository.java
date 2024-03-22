package com.project.security.repository;

import com.project.security.entity.LoginDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<LoginDetails, String> {
    Optional<LoginDetails> getByUserName(String userName);
}
