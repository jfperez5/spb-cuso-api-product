package com.caneksoft.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Getter
@Setter
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description; 
    private BigDecimal price;
    
    @ManyToOne  
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(columnDefinition = "BIT(1) default 0")
    private Boolean status;
}


/* 
Creación de un API REST con Springboot 3, JPA, MySQL aplicando buenas prácticas - 2024
By Dev Dominio  time:2:58:28
25/07/2024
https://www.youtube.com/watch?v=N0NMWYl8wYk
*/
