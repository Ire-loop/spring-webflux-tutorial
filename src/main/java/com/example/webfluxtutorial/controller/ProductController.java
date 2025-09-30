package com.example.webfluxtutorial.controller;

import com.example.webfluxtutorial.dto.request.ProductRequestDTO;
import com.example.webfluxtutorial.dto.response.ProductResponseDTO;
import com.example.webfluxtutorial.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    public Mono<ProductResponseDTO> getProductById(@PathVariable("id") UUID productId) {
        return productService.findProductById(productId);
    }

    @GetMapping("/products")
    public Flux<ProductResponseDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/product")
    public Mono<ResponseEntity<ProductResponseDTO>> createProduct(@Valid @RequestBody ProductRequestDTO requestDTO) {
        return productService.createProduct(requestDTO)
                .map(productResponseDTO -> ResponseEntity.status(HttpStatus.CREATED).body(productResponseDTO));
    }

    @PatchMapping("/product/{id}")
    public Mono<ProductResponseDTO> updateProduct(@PathVariable("id") UUID productId, @Valid @RequestBody ProductRequestDTO requestDTO) {
        return productService.updateProduct(productId, requestDTO);
    }

    @DeleteMapping("/product/{id}")
    public Mono<ResponseEntity<Void>> deleteProduct(@PathVariable("id") UUID productId) {
        return productService.deleteProduct(productId).then(Mono.just(ResponseEntity.noContent().build()));
    }
}
