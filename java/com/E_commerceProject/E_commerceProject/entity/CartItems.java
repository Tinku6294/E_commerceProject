package com.E_commerceProject.E_commerceProject.entity;

import com.E_commerceProject.E_commerceProject.dto.CartItemDto;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
public class CartItems {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

       private Long id;

   private Long price;

   private Long quantity;


   @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "product_id",nullable = false)
    @OnDelete(action=OnDeleteAction.CASCADE)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "user_id",nullable = false)
    @OnDelete(action=OnDeleteAction.CASCADE)
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
    private Order order;
    public CartItemDto getCartDto(){
        CartItemDto cartItemDto= new CartItemDto();
        cartItemDto.setId(id);
        cartItemDto.setPrice(price);
        cartItemDto.setProductId(product.getId());
        cartItemDto.setQuantity(quantity);
        cartItemDto.setOrderId(user.getId());
        cartItemDto.setProductName(user.getName());
        return cartItemDto;
    }

}
