package com.E_commerceProject.E_commerceProject.services.cart;

import com.E_commerceProject.E_commerceProject.dto.AddProductInCartDto;
import com.E_commerceProject.E_commerceProject.dto.CartItemDto;
import com.E_commerceProject.E_commerceProject.dto.OrderDto;
import com.E_commerceProject.E_commerceProject.entity.CartItems;
import com.E_commerceProject.E_commerceProject.entity.Order;
import com.E_commerceProject.E_commerceProject.entity.Product;
import com.E_commerceProject.E_commerceProject.entity.User;
import com.E_commerceProject.E_commerceProject.enums.OrderStatus;
import com.E_commerceProject.E_commerceProject.repsitory.CartItemsRepository;
import com.E_commerceProject.E_commerceProject.repsitory.OrderRepository;
import com.E_commerceProject.E_commerceProject.repsitory.ProductRepository;
import com.E_commerceProject.E_commerceProject.repsitory.UserRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartItemsRepository cartItemsRepository;
    @Autowired
    private ProductRepository productRepository;
    public ResponseEntity<?> addProductToCart(AddProductInCartDto addProductInCartDto){
        Order activeOrder =orderRepository.findByUserIdAndOrderStatus(addProductInCartDto.getUserId(),OrderStatus.Pending);
        Optional<CartItems> optionalCartItems=cartItemsRepository.findByProductIdAndOrderIdAndUserId
                (addProductInCartDto.getProductId(),activeOrder.getId(),addProductInCartDto.getUserId());
        if(optionalCartItems.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
        else {
            Optional<Product> optionalProduct =productRepository.findById(addProductInCartDto.getProductId());
            Optional<User> optionalUser=userRepository.findById(addProductInCartDto.getUserId());
            if(optionalProduct.isPresent() && optionalUser.isPresent()){
                CartItems cart =new CartItems();
                cart.setProduct(optionalProduct.get());
                cart.setPrice(optionalProduct.get().getPrice());
                cart.setQuantity(1L);
                cart.setUser(optionalUser.get());
                cart.setOrder(activeOrder);
                CartItems updateCart = cartItemsRepository.save(cart);
                activeOrder.setTotalAmount(activeOrder.getTotalAmount()+cart.getPrice());
                activeOrder.setAmount(activeOrder.getAmount()+cart.getPrice());
                activeOrder.getCartItems().add(cart);
                orderRepository.save(activeOrder);
                return ResponseEntity.status(HttpStatus.CREATED).body(cart);

            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User of product not found");
            }
        }
    }

    public OrderDto getCartByUserId(Long userId){
        Order activeOrder=orderRepository.findByUserIdAndOrderStatus(userId, OrderStatus.Pending);
        List<CartItemDto> cartItemDtoList=activeOrder.getCartItems().stream().map(CartItems::getCartDto).collect(Collectors.toList());
        OrderDto orderDto=new OrderDto();
        orderDto.setAmount(activeOrder.getAmount());
        orderDto.setId(activeOrder.getId());
        orderDto.setOrderStatus(activeOrder.getOrderStatus());
        orderDto.setDiscount(activeOrder.getDiscount());
        orderDto.setTotalAmount(activeOrder.getTotalAmount());
        orderDto.setCartItems(cartItemDtoList);
        return orderDto;

    }
}
