package com.E_commerceProject.E_commerceProject.services.auth;
import com.E_commerceProject.E_commerceProject.entity.Order;
import com.E_commerceProject.E_commerceProject.entity.User;
import com.E_commerceProject.E_commerceProject.dto.SignupRequest;
import com.E_commerceProject.E_commerceProject.dto.UserDto;
import com.E_commerceProject.E_commerceProject.enums.OrderStatus;
import com.E_commerceProject.E_commerceProject.enums.UserRole;
import com.E_commerceProject.E_commerceProject.repsitory.OrderRepository;
import com.E_commerceProject.E_commerceProject.repsitory.UserRepository;
import jakarta.annotation.PostConstruct;
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
    @Autowired
    private OrderRepository orderRepository;


    public UserDto createUser(SignupRequest signupRequest)
    {
     User user=new User();
     user.setEmail(signupRequest.getEmail());
     user.setName(signupRequest.getName());
     user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
     user.setRole(UserRole.CUSTOMER);
     User createdUser=userRepository.save(user);
     Order order=new Order();
     order.setAmount(0l);
     order.setTotalAmount(0L);
      order.setDiscount(0L);
      order.setUser(createdUser);
      order.setOrderStatus(OrderStatus.Pending);
      orderRepository.save(order);

     UserDto userDto=new UserDto();
     userDto.setId(createdUser.getId());
     return userDto;
    }
    public Boolean hasUserWithEmail(String email){
     return userRepository.findFirstBYEmail(email).isPresent();
    }
    @PostConstruct
    public void createAdminAccount(){
        User adminAccount=userRepository.findByRole(UserRole.ADMIN);
        if(null == adminAccount){
            User user=new User();
            user.setEmail("admin@test.com");
            user.setName("admin");
            user.setRole(UserRole.ADMIN);
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
        userRepository.save(user);
        }
    }

}
