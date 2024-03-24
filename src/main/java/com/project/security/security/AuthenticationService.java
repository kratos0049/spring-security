package com.project.security.security;

import com.project.security.dto.request.AuthRequestDto;
import com.project.security.dto.request.UserRequestDto;
import com.project.security.dto.response.AuthenticationResponseDto;
import com.project.security.entity.UserDetails;
import com.project.security.repository.UserDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserDetailsRepository userDetailsRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponseDto register(UserRequestDto userRequestDto) {

        var user = UserDetails.builder()
                .userName(userRequestDto.getUserName())
                .password(passwordEncoder.encode(userRequestDto.getPassword()))
                .role(userRequestDto.getRole())
                .build();
        userDetailsRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseDto.builder().jwtToken(jwtToken).build();
    }

    public AuthenticationResponseDto authenticate(AuthRequestDto authRequest) {
        authenticationManager.authenticate(new
                UsernamePasswordAuthenticationToken(authRequest.getUserName(),authRequest.getPassword())
        );
        var user = UserDetails.builder().userName(authRequest.getUserName()).password(authRequest.getPassword()).build();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseDto.builder().jwtToken(jwtToken).build();
    }
}
