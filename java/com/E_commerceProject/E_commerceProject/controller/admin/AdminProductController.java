package com.E_commerceProject.E_commerceProject.controller.admin;

import com.E_commerceProject.E_commerceProject.controller.admin.adminproduct.AdminProductService;
import com.E_commerceProject.E_commerceProject.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminProductController {
    private final AdminProductService adminProductService;
    @PostMapping("/products")
    public ResponseEntity<ProductDto> addProduct(@ModelAttribute ProductDto productDto) throws IOException {
        ProductDto productDto1=adminProductService.addProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDto1);

    }
    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts()
    {
        List<ProductDto> productDtos=adminProductService.getAllProduct();
        return ResponseEntity.ok(productDtos);

    }
    @GetMapping("/search/{name}")
    public ResponseEntity<List<ProductDto>> getAllProductByName(@PathVariable String name)
    {
        List<ProductDto> productDtos=adminProductService.getAllProductByName(name);
        return ResponseEntity.ok(productDtos);

    }
    @DeleteMapping("/product/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId){
        boolean deleted = adminProductService.deleteProduct(productId);
        if(deleted){
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
