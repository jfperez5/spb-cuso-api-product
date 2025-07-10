package com.caneksoft.repository;

import com.caneksoft.entity.EstadoProducto;
import com.caneksoft.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {

    Optional<Producto> findByNombreProducto(String nombreProducto);

    Optional<Producto> findByIdProducto(Long idProducto);

    List<Producto> findByEstadoProducto(EstadoProducto estadoProducto);
}