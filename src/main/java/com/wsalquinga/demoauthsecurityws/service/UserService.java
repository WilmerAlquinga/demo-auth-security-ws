package com.wsalquinga.demoauthsecurityws.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wsalquinga.demoauthsecurityws.model.ApplicationUser;
import com.wsalquinga.demoauthsecurityws.model.Role;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("In the UserDetailsService");

        if(!username.equals("Wilmer")) throw new UsernameNotFoundException("Not Wilmer");

        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1L, "USER"));

        return new ApplicationUser(1L, "Wilmer", encoder.encode("password"), roles);
    }
    
}
