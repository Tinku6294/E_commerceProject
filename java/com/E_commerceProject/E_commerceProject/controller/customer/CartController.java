package com.E_commerceProject.E_commerceProject.controller.customer;

import com.E_commerceProject.E_commerceProject.dto.AddProductInCartDto;
import com.E_commerceProject.E_commerceProject.dto.OrderDto;
import com.E_commerceProject.E_commerceProject.entity.Order;
import com.E_commerceProject.E_commerceProject.services.cart.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    @PostMapping("/cart")
    public ResponseEntity<?> addProductToCart(@RequestBody AddProductInCartDto addProductInCartDto){
        return cartService.addProductToCart(addProductInCartDto);
    }
    @GetMapping("/cart/{userId}")
    public ResponseEntity<?> getCartByUserId(@PathVariable Long userId) {
        OrderDto orderDto = cartService.getCartByUserId(userId);


        return ResponseEntity.status(HttpStatus.OK).body(orderDto);
    }

}
