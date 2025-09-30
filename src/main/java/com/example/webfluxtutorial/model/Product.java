package com.example.webfluxtutorial.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Table("products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    private UUID id;

    @Column("name")
    private String name;

    @Column("description")
    private String description;

    @Column("brand")
    private String brand;

    @Column("category")
    private ProductCategory category;

    @Column("price")
    private BigDecimal price;

    @Column("quantity")
    private int quantity;

    @Column("created_at")
    private LocalDateTime createdDate;

    @Column("updated_at")
    private LocalDateTime updatedDate;
}
