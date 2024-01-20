package com.E_commerceProject.E_commerceProject.services.auth;
import com.E_commerceProject.E_commerceProject.entity.User;
import com.E_commerceProject.E_commerceProject.dto.SignupRequest;
import com.E_commerceProject.E_commerceProject.dto.UserDto;
import com.E_commerceProject.E_commerceProject.enums.UserRole;
import com.E_commerceProject.E_commerceProject.repsitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Signature;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public UserDto crearUser(SignupRequest signupRequest)
    {
     User user=new User();
     user.setEmail(signupRequest.getEmail());
     user.setName(signupRequest.getName());
     user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
     user.setRole(UserRole.CUSTOMER);
     User createdUser=userRepository.save(user);
     UserDto userDto=new UserDto();
     userDto.setId(createdUser.getId());
     return userDto;
    }
    public Boolean hasUserWithEmail(String email)
}
