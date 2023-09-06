package com.wsalquinga.demoauthsecurityws.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wsalquinga.demoauthsecurityws.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByAuthority(String authority);
}
