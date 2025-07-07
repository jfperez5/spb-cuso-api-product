package com.caneksoft.service;

import java.util.List;
import java.util.Optional;

import com.caneksoft.dto.ProductoDTO;
import com.caneksoft.entity.EstadoProducto;

public interface ProductoService {
    ProductoDTO registrarProducto(Long categoriaId, ProductoDTO productoDTO);

    List<ProductoDTO> listarProductos();

    Optional<ProductoDTO> buscarPorNombre(String nombre);

    Optional<ProductoDTO> buscarPorId(Long idProducto);

    ProductoDTO actualizarProducto(Long idProducto,ProductoDTO productoDTO);

    void eliminarProducto(Long idProducto);

    ProductoDTO cambiarEstadoProducto(Long idProducto, EstadoProducto nuevoEstadoProducto);

    List<ProductoDTO> obtenerProductosPorEstado(EstadoProducto estadoProducto);

}
