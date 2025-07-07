package com.caneksoft.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caneksoft.entity.EstadoProducto;
import com.caneksoft.entity.Producto;
import com.caneksoft.repository.ProductoRepository;
import com.caneksoft.service.ProductoService;

import lombok.SneakyThrows;

@Service
public class ProductoServiceImpl implements ProductoService{

    // @Autowired
    // private ProductoRepository productoRepository;
    /* Nota: El uso de Autowired ya no es recomendable a partir de las nuevas versiones 
       se debe usar desde el constructor ejemplo del uso de constructo */
    
       private final ProductoRepository productoRepository;

       public ProductoServiceImpl(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
       }

       @Override
       public Producto registraProducto(Producto producto) {
            return productoRepository.save(producto);
       }

       @Override
       public List<Producto> listaProductos() {
            return productoRepository.findAll();
       }

       @Override
       public Optional<Producto> buscarPorNombre(String nombre) {
         return productoRepository.findByNombreProducto(nombre);
       }

       @Override
       public Optional<Producto> buscarPorId(Long idProducto) {
        return productoRepository.findByIdProducto(idProducto);
       }

       @Override
       @SneakyThrows
       public Producto actualizaProducto(Long idProducto, Producto producto){
            Producto productoExistente = productoRepository.findByIdProducto(idProducto).orElseThrow(()-> new Exception("Producto con ID: " + idProducto + "no encontrado"));

            productoExistente.setNombreProducto(producto.getNombreProducto());
            productoExistente.setDescripcion(producto.getDescripcion());
            productoExistente.setPrecio(producto.getPrecio());
            productoExistente.setCantidad(producto.getCantidad());
            productoExistente.setEstadoProducto(producto.getEstadoProducto());

            Producto productoActualizado = productoRepository.save(productoExistente);
            return productoActualizado;
       }

       @Override
       @SneakyThrows
       public void eliminarProducto(Long idProducto) {
        productoRepository.findByIdProducto(idProducto).orElseThrow(()-> new Exception("Producto con ID: " + idProducto + "no encontrado"));
        productoRepository.deleteById(idProducto);
       }

       @Override
       @SneakyThrows
       public Producto cambiarEstadoProducto(Long idProducto, EstadoProducto nuevoEstadoProducto) {
        Producto productoExistente = productoRepository.findByIdProducto(idProducto).orElseThrow(()-> new Exception("Producto con ID: " + idProducto + "no encontrado"));
        productoExistente.setEstadoProducto(nuevoEstadoProducto);
        return productoRepository.save(productoExistente);
       }

       @Override
       public List<Producto> obteneProductosPorEstado(EstadoProducto estadoProducto) {
        return productoRepository.findByEstado(estadoProducto);
       }


       
}
