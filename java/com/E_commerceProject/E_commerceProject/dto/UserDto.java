package com.E_commerceProject.E_commerceProject.dto;

import com.E_commerceProject.E_commerceProject.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String email;
    private String name;
    private UserRole userRole;


}
