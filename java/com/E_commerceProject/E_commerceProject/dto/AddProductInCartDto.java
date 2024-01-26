package com.E_commerceProject.E_commerceProject.dto;

import com.E_commerceProject.E_commerceProject.entity.Product;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.PrimitiveIterator;

@Data

public class AddProductInCartDto {

    private Long  userId;
    private Long productId;


}
