package com.caneksoft.controller;

import java.net.URI;
import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caneksoft.dto.CreateProductRequest;
import com.caneksoft.dto.ProductResponse;
import com.caneksoft.service.ProductService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    
    @GetMapping
    public List<ProductResponse> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductResponse findById(@PathVariable Long id) {
        return productService.findById(id);
    }


    @GetMapping("/category/{categoryId}")
    public List<ProductResponse> findByCategoryId(@PathVariable Long categoryId) {        
        return productService.findByCategoryId(categoryId);
    }    

    @PostMapping
    public ResponseEntity<ProductResponse> save(@Valid @RequestBody CreateProductRequest request) {
        ProductResponse response = productService.save(request);
        return ResponseEntity
        .created(URI.create("/api/products/" + response.getId()))
        .body(response);
    }

    @PutMapping("{id}")
    public ProductResponse update(@PathVariable Long id, @Valid @RequestBody CreateProductRequest request) {
        return productService.update(id, request);
    }

    @DeleteMapping
    public void deleteById(@PathVariable Long id){
        productService.deleteById(id);
    }
    

}
