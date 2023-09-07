package com.wsalquinga.demoauthsecurityws.dto.res;

import java.util.Set;

import lombok.Data;

@Data
public class UserResDTO {

    private Long userId;
    
    private String username;

    private Set<RoleResDTO> roles;
}
