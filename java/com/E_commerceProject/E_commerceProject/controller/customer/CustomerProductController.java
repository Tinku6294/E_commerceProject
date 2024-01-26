package com.E_commerceProject.E_commerceProject.controller.customer;

import com.E_commerceProject.E_commerceProject.dto.ProductDto;
import com.E_commerceProject.E_commerceProject.services.customer.CustomerProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/customer")
@RestController
@RequiredArgsConstructor
public class CustomerProductController {

    private final CustomerProductService customerProductService;
    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts()
    {
        List<ProductDto> productDtos=customerProductService.getAllProduct();
        return ResponseEntity.ok(productDtos);

    }
    @GetMapping("/search/{name}")
    public ResponseEntity<List<ProductDto>> getAllProductByName(@PathVariable String name)
    {
        List<ProductDto> productDtos=customerProductService.searchProductByTitle(name);
        return ResponseEntity.ok(productDtos);

    }
}
