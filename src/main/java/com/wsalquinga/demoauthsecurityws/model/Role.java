package com.wsalquinga.demoauthsecurityws.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Long roleId;

    private String authority;

    @Override
    public String getAuthority() {
        return this.authority;
    }

    public Role(String authority) {
        this.authority = authority;
    }
    
}
