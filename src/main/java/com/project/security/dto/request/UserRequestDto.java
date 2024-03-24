package com.project.security.dto.request;

import com.project.security.constant.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Service
public class UserRequestDto {
    private String userName;
    private String password;
    private Role role;
}
