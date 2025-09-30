package com.example.webfluxtutorial.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class ProductResponseDTO {

    private UUID id;
    private String name;
    private String description;
    private String brand;
    private String productCategory;
    private BigDecimal price;
    private int quantity;
}
