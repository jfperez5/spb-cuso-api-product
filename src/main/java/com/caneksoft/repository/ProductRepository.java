package com.caneksoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caneksoft.entity.Category;
import com.caneksoft.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
    List<Product> findAllByCategory(Category category);

}
