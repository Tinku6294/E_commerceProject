package com.E_commerceProject.E_commerceProject.dto;

import com.E_commerceProject.E_commerceProject.entity.CartItems;
import com.E_commerceProject.E_commerceProject.entity.User;
import com.E_commerceProject.E_commerceProject.enums.OrderStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class OrderDto {
    private Long id ;
    private String orderDescription;
    private Date date;
    private Long amount;
    private String address;
    private String payment;
    private OrderStatus orderStatus;
    private Long totalAmount;
    private Long discount;
    private UUID trackingId;

    private String userName;

    private List<CartItemDto> cartItems;
}
