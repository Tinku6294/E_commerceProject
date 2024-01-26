package com.E_commerceProject.E_commerceProject.repsitory;

import com.E_commerceProject.E_commerceProject.entity.User;
import com.E_commerceProject.E_commerceProject.enums.UserRole;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findFirstBYEmail(String username);

    User findByRole(UserRole userRole);



    }
