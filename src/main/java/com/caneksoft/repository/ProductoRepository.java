package com.caneksoft.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caneksoft.entity.EstadoProducto;
import com.caneksoft.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long>{
    Optional<Producto>findByNombreProducto(String nombreProducto);
    Optional<Producto>findByIdProducto(Long idProducto);
    List<Producto>findByEstado(EstadoProducto estadoProducto);
    
}
