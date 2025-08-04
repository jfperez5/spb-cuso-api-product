package com.caneksoft.service;

import java.util.List;

import com.caneksoft.dto.CreateProductRequest;
import com.caneksoft.dto.ProductResponse;

public interface ProductService {
    
    ProductResponse findById(Long id);
    List<ProductResponse> findAll();
    List<ProductResponse> findByCategoryId(Long categoryId);
    ProductResponse save(CreateProductRequest request);
    ProductResponse update(Long id, CreateProductRequest request);
    void deleteById(Long id);
}
