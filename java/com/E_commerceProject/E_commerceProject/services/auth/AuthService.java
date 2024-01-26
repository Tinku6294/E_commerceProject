package com.E_commerceProject.E_commerceProject.services.auth;

import com.E_commerceProject.E_commerceProject.dto.SignupRequest;
import com.E_commerceProject.E_commerceProject.dto.UserDto;

public interface AuthService {
     Boolean hasUserWithEmail(String email);
    UserDto createUser(SignupRequest signupRequest);
}
