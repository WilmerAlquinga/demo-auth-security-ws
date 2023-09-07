package com.wsalquinga.demoauthsecurityws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wsalquinga.demoauthsecurityws.dto.req.UserReqDTO;
import com.wsalquinga.demoauthsecurityws.dto.res.UserResDTO;
import com.wsalquinga.demoauthsecurityws.service.AuthenticationService;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<UserResDTO> registerUser(
            @RequestBody UserReqDTO userReqDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.authenticationService.registerUser(userReqDTO.getUsername(), userReqDTO.getPassword()));
    }
}
