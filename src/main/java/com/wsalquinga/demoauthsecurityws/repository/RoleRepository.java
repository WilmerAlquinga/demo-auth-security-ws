package com.wsalquinga.demoauthsecurityws.repository;

import com.wsalquinga.demoauthsecurityws.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByAuthority(String authority);
}
