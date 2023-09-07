package com.wsalquinga.demoauthsecurityws.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.wsalquinga.demoauthsecurityws.dto.res.UserResDTO;
import com.wsalquinga.demoauthsecurityws.mapper.UserMapper;
import com.wsalquinga.demoauthsecurityws.model.ApplicationUser;
import com.wsalquinga.demoauthsecurityws.model.Role;
import com.wsalquinga.demoauthsecurityws.repository.RoleRepository;
import com.wsalquinga.demoauthsecurityws.repository.UserRepository;

@Service
@Transactional
public class AuthenticationService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    public UserResDTO registerUser(String username, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();

        Set<Role> roles = new HashSet<>();
        roles.add(userRole);

        ApplicationUser createdUser = this.userRepository.save(new ApplicationUser(0L, username, encodedPassword, roles));
        return this.userMapper.toRes(createdUser);
    }

}
