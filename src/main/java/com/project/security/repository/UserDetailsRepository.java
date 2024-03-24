package com.project.security.repository;

import com.project.security.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<UserDetails, String> {
    Optional<UserDetails> getByUserName(String userName);
}
