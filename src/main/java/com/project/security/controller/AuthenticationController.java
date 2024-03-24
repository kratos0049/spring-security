package com.project.security.controller;

import com.project.security.dto.request.AuthRequestDto;
import com.project.security.dto.request.UserRequestDto;
import com.project.security.dto.response.AuthenticationResponseDto;
import com.project.security.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/auth")
public class AuthenticationController {


    @Autowired
    AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDto> register(@RequestBody UserRequestDto userRequestDto)
    {
        return ResponseEntity.ok().body(authenticationService.register(userRequestDto));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDto> authenticate(@RequestBody AuthRequestDto authRequest){
        return ResponseEntity.ok().body(authenticationService.authenticate(authRequest));
    }
}
