package com.E_commerceProject.E_commerceProject.services.auth;

import com.E_commerceProject.E_commerceProject.dto.SignupRequest;
import com.E_commerceProject.E_commerceProject.dto.UserDto;

public interface AuthService {
    UserDto crearUser(SignupRequest signupRequest)
}
