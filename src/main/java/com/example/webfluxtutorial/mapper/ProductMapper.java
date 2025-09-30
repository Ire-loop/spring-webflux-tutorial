package com.example.webfluxtutorial.mapper;

import com.example.webfluxtutorial.dto.request.ProductRequestDTO;
import com.example.webfluxtutorial.dto.response.ProductResponseDTO;
import com.example.webfluxtutorial.model.Product;
import com.example.webfluxtutorial.model.ProductCategory;

import java.time.LocalDateTime;

public class ProductMapper {

    public static ProductResponseDTO toProductResponseDTO(Product product) {
        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .brand(product.getBrand())
                .productCategory(
                        product.getCategory() != null ? product.getCategory().name() : null
                )
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }

    public static Product toProduct(ProductRequestDTO requestDTO) {
        return Product.builder()
                .name(requestDTO.getName())
                .description(requestDTO.getDescription())
                .brand(requestDTO.getBrand())
                .category(ProductCategory.valueOf(requestDTO.getProductCategory()))
                .price(requestDTO.getPrice())
                .quantity(requestDTO.getQuantity())
                .createdDate(LocalDateTime.now())  // Set timestamps manually
                .updatedDate(LocalDateTime.now())
                .build();
    }
}
