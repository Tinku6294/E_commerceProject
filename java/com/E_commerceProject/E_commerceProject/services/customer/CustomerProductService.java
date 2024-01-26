package com.E_commerceProject.E_commerceProject.services.customer;

import com.E_commerceProject.E_commerceProject.dto.ProductDto;
import com.E_commerceProject.E_commerceProject.entity.Product;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface CustomerProductService {
    List<ProductDto> searchProductByTitle(String title);
    List<ProductDto>getAllProduct();
}
