package com.E_commerceProject.E_commerceProject.services.cart;

import com.E_commerceProject.E_commerceProject.dto.AddProductInCartDto;
import com.E_commerceProject.E_commerceProject.dto.OrderDto;
import org.springframework.http.ResponseEntity;

public interface CartService{
    ResponseEntity<?> addProductToCart(AddProductInCartDto addProductInCartDto);
    OrderDto getCartByUserId(Long userId);
}
