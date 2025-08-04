package com.caneksoft.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.caneksoft.dto.CreateProductRequest;
import com.caneksoft.dto.ProductResponse;
import com.caneksoft.entity.Product;
import com.caneksoft.exceptions.CategoryNotFoundException;
import com.caneksoft.exceptions.ProductNotFoundException;
import com.caneksoft.mapper.ProductMapper;
import com.caneksoft.repository.CategoryRepository;
import com.caneksoft.repository.ProductRepository;
import com.caneksoft.service.ProductService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponse findById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::toProductResponse)
                .orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public List<ProductResponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductResponse)
                .collect(Collectors.toList());
    }
    
    @Override
    public List<ProductResponse> findByCategoryId(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .map(category -> productRepository.findAllByCategory(category))
                .map(products -> products.stream()
                    .map(productMapper::toProductResponse)
                    .collect(Collectors.toList()) )
                .orElseThrow(CategoryNotFoundException::new);
    }

    @Override
    public ProductResponse save(CreateProductRequest request) {
        return categoryRepository.findById(request.getCategoryId())
                .map(category -> {
                    Product product = new Product();
                    product.setName(request.getName());
                    product.setDescription(request.getDescription());
                    product.setPrice(request.getPrice());
                    product.setCategory(category);
                    product.setStatus(Boolean.TRUE);
                    return productRepository.save(product);
                })
                .map(productMapper::toProductResponse)
                .orElseThrow(CategoryNotFoundException::new);
    }
 
    @Override
    public ProductResponse update(Long id, CreateProductRequest request) {
       return productRepository.findById(id)
                .map(product -> categoryRepository
                .findById(request.getCategoryId())
                .map(category ->{
                    product.setName(request.getName());
                    product.setDescription(request.getDescription());
                    product.setPrice(request.getPrice());
                    return productRepository.save(product);
                })
                .orElseThrow(CategoryNotFoundException::new))
                .map(productMapper::toProductResponse)
                .orElseThrow(ProductNotFoundException::new);
    }


    @Override
    public void deleteById(Long id) {
       if(!productRepository.existsById(id)) {
            throw new ProductNotFoundException();
        }
        productRepository.deleteById(id);
    }


}
