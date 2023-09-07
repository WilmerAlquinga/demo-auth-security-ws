package com.wsalquinga.demoauthsecurityws.mapper;

import java.util.Set;

import org.mapstruct.Mapper;

import com.wsalquinga.demoauthsecurityws.dto.res.RoleResDTO;
import com.wsalquinga.demoauthsecurityws.model.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleResDTO toRes(Role role);

    Set<RoleResDTO> toRes(Set<Role> roles);
}
