package com.caneksoft.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable=false)
    private Long id;
    private String nombre;
    private String email;
    private int prioridad;
}

/* 
 * Desarrollar Api Rest con Java Spring Boot, explicación completa en 20 min.
 * by DATACLOUDER 
   Fecha: 3/06/2020  time:20.56 
 * https://youtu.be/vTu2HQrXtyw?list=TLPQMTkwNzIwMjUlJoMrAB6GhQ
 * 
*/