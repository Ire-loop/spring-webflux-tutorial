package com.example.webfluxtutorial.service;

import com.example.webfluxtutorial.dto.request.ProductRequestDTO;
import com.example.webfluxtutorial.dto.response.ProductResponseDTO;
import com.example.webfluxtutorial.exception.ProductNotFoundException;
import com.example.webfluxtutorial.mapper.ProductMapper;
import com.example.webfluxtutorial.model.Product;
import com.example.webfluxtutorial.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Method 1: Find product by ID
    public Mono<ProductResponseDTO> findProductById(UUID productId) {
        return productRepository.findById(productId)
                .switchIfEmpty(Mono.error(new ProductNotFoundException("Product not found with id: " + productId)))
                .map(ProductMapper::toProductResponseDTO);
    }

    // Method 2: Get all products
    public Flux<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll()
                .map(ProductMapper::toProductResponseDTO);
    }

    // Method 3: Create a new product
    public Mono<ProductResponseDTO> createProduct(ProductRequestDTO requestDTO) {
        return productRepository.save(ProductMapper.toProduct(requestDTO))
                .map(ProductMapper::toProductResponseDTO);
    }

    public Mono<ProductResponseDTO> updateProduct(UUID productId, ProductRequestDTO requestDTO) {
        return productRepository.findById(productId)
                .switchIfEmpty(Mono.error(new ProductNotFoundException("Product not found with id: " + productId)))
                .map(existingProduct -> Product.builder()
                        .id(existingProduct.getId())
                        .name(existingProduct.getName())
                        .description(existingProduct.getDescription())
                        .brand(existingProduct.getBrand())
                        .category(existingProduct.getCategory())
                        .price(requestDTO.getPrice())
                        .quantity(requestDTO.getQuantity())
                        .build())
                .flatMap(productRepository::save)
                .map(ProductMapper::toProductResponseDTO);

    }

    public Mono<Void> deleteProduct(UUID productId) {
        return productRepository.findById(productId)
                .switchIfEmpty(Mono.error(new ProductNotFoundException("Product not found with id: " + productId)))
                .flatMap(productRepository::delete);
    }
}
