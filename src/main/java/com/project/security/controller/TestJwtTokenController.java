package com.project.security.controller;

import com.project.security.dto.request.AuthRequestDto;
import com.project.security.dto.request.UserRequestDto;
import com.project.security.dto.response.AuthenticationResponseDto;
import com.project.security.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/test-jwt")
public class TestJwtTokenController {


    @Autowired
    AuthenticationService authenticationService;
    @GetMapping()
    public ResponseEntity<String> testJwtToken()
    {
        return ResponseEntity.ok().body("Valid Jwt Token!");
    }
}
