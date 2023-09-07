package com.wsalquinga.demoauthsecurityws.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.wsalquinga.demoauthsecurityws.dto.req.UserReqDTO;
import com.wsalquinga.demoauthsecurityws.dto.res.UserResDTO;
import com.wsalquinga.demoauthsecurityws.model.ApplicationUser;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UserMapper {
    
    @Mapping(source = "authorities", target = "roles")
    UserResDTO toRes(ApplicationUser applicationUser);

    ApplicationUser toEntity(UserReqDTO userReqDTO);
}
