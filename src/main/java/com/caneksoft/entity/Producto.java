package com.caneksoft.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Long idProducto;

    @Column(name="nombre_producato", nullable = false)
    private String nombreProducto;

    private String descripcion;

    @Column (name="precio", nullable = false)
    private double precio;

    @Column(name ="cantidad", nullable = false)
    private int cantidad;

    @Enumerated(EnumType.STRING)
    @Column (name="estado_producto", nullable = false)
    private EstadoProducto estadoProducto;
}
