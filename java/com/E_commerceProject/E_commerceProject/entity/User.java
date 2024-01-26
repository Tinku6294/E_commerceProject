package com.E_commerceProject.E_commerceProject.entity;

import com.E_commerceProject.E_commerceProject.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Data
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String email;
    private String password;
    private String name;
    private UserRole role;

}
