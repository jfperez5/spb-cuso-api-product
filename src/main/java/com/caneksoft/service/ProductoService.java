package com.caneksoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.caneksoft.entity.EstadoProducto;
import com.caneksoft.entity.Producto;

public interface ProductoService {
    Producto registraProducto(Producto producto);
    List<Producto> listaProductos();
    Optional<Producto>buscarPorNombre(String nombre);
    Optional<Producto>buscarPorId(Long idProducto);
    Producto actualizaProducto(Long idProducto, Producto producto);
    void eliminarProducto(Long idProducto);
    Producto cambiarEstadoProducto(Long idProducto, EstadoProducto nuevoEstadoProducto);
    List<Producto>obteneProductosPorEstado(EstadoProducto estadoProducto);

}
