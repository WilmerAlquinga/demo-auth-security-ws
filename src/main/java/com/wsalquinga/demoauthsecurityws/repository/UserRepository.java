package com.wsalquinga.demoauthsecurityws.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wsalquinga.demoauthsecurityws.model.ApplicationUser;

public interface UserRepository extends JpaRepository<ApplicationUser, Long> {
    Optional<ApplicationUser> findByUsername(String username);
}
