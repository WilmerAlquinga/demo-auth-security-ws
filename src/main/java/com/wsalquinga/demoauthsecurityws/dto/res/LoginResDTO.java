package com.wsalquinga.demoauthsecurityws.dto.res;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginResDTO {

    private Long userId;

    private String username;

    private String jwt;

    private Set<RoleResDTO> roles;
}
