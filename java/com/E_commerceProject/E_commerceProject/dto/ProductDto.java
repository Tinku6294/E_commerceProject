package com.E_commerceProject.E_commerceProject.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class ProductDto {
    private Long id;
    private String name;
    private Long price;
    private String description;
    private Long categoryId;
    private String categoryName;
    //private MultipartFile img;
}
