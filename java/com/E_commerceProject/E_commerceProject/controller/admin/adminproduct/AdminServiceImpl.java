package com.E_commerceProject.E_commerceProject.controller.admin.adminproduct;

import com.E_commerceProject.E_commerceProject.dto.ProductDto;
import com.E_commerceProject.E_commerceProject.entity.Category;
import com.E_commerceProject.E_commerceProject.entity.Product;
import com.E_commerceProject.E_commerceProject.repsitory.CategoryRepository;
import com.E_commerceProject.E_commerceProject.repsitory.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.PrimitiveIterator;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminProductService{
    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public ProductDto addProduct(ProductDto productDto) throws IOException {

        Product product=new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());

        Category category=categoryRepository.findById(productDto.getCategoryId()).orElseThrow();

        product.setCategory(category);
        return productRepository.save(product).getDto();
    }
    public List<ProductDto> getAllProduct() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(Product::getDto).collect(Collectors.toList());
    }
    public List<ProductDto> getAllProductByName(String name) {
        List<Product> products = productRepository.findAllByNameContaining(name);
        return products.stream().map(Product::getDto).collect(Collectors.toList());
    }
    public boolean deleteProduct(Long id){
        Optional<Product> optionalProduct=productRepository.findById(id);
        if(optionalProduct.isPresent()){
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

