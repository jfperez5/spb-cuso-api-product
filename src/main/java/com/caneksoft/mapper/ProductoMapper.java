package com.caneksoft.mapper;

import com.caneksoft.dto.ProductoDTO;
import com.caneksoft.entity.Producto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Producto toEntity(ProductoDTO productoDTO){
        return modelMapper.map(productoDTO,Producto.class);
    }

    public void toEntity(ProductoDTO productoDTO,Producto productoExistente){
        modelMapper.map(productoDTO,productoExistente);
    }

    public ProductoDTO toDTO(Producto producto){
        return modelMapper.map(producto,ProductoDTO.class);
    }
}