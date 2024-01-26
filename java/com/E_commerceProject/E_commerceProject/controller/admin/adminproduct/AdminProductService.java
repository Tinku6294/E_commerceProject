package com.E_commerceProject.E_commerceProject.controller.admin.adminproduct;

import com.E_commerceProject.E_commerceProject.dto.ProductDto;

import java.io.IOException;
import java.util.List;

public interface AdminProductService {
    ProductDto addProduct(ProductDto productDto) throws IOException;
    List<ProductDto> getAllProduct();
    List<ProductDto> getAllProductByName(String name);
    boolean deleteProduct(Long id);

}
