package com.wsalquinga.demoauthsecurityws.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.wsalquinga.demoauthsecurityws.dto.res.LoginResDTO;
import com.wsalquinga.demoauthsecurityws.dto.res.RoleResDTO;
import com.wsalquinga.demoauthsecurityws.dto.res.UserResDTO;
import com.wsalquinga.demoauthsecurityws.mapper.RoleMapper;
import com.wsalquinga.demoauthsecurityws.mapper.UserMapper;
import com.wsalquinga.demoauthsecurityws.model.ApplicationUser;
import com.wsalquinga.demoauthsecurityws.model.Role;
import com.wsalquinga.demoauthsecurityws.repository.RoleRepository;
import com.wsalquinga.demoauthsecurityws.repository.UserRepository;

@Service
@Transactional
@AllArgsConstructor
public class AuthenticationService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private UserMapper userMapper;
    private RoleMapper roleMapper;
    private AuthenticationManager authenticationManager;
    private TokenService tokenService;

    public UserResDTO registerUser(String username, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);
        Set<RoleResDTO> rolesDTO = this.roleMapper.toRes(roles);

        ApplicationUser createdUser = this.userRepository
                .save(new ApplicationUser(0L, username, encodedPassword, roles));
        UserResDTO user = this.userMapper.toRes(createdUser);
        user.setRoles(rolesDTO);
        return user;
    }

    public LoginResDTO login(String username, String password) {

        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
            Authentication auth = authenticationManager.authenticate(authenticationToken);
            String token = tokenService.generateJwt(auth);

            ApplicationUser user = this.userRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found"));

            Set<RoleResDTO> rolesDTO = this.roleMapper.toRes(new HashSet<>((Collection<? extends Role>) user.getAuthorities()));

            return LoginResDTO.builder()
                    .userId(user.getUserId())
                    .username(user.getUsername())
                    .jwt(token)
                    .roles(rolesDTO)
                    .build();

        } catch (AuthenticationException e) {
            System.out.println("Login error: " + e.getMessage());
            return new LoginResDTO();
        }
    }

}
