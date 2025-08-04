package com.caneksoft.mapper;

// import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

// import com.caneksoft.dto.CreateProductRequest;
import com.caneksoft.dto.ProductResponse;
import com.caneksoft.entity.Product;

import static com.caneksoft.utils.Constants.ACTIVE_STATUS;
import static com.caneksoft.utils.Constants.INACTIVE_STATUS;


@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

  
    @Mapping(target = "status", expression = "java(mapStatus(product))")
    ProductResponse toProductResponse(Product product);

    // Product toProduct(CreateProductRequest request);

    // Product toProduct(UpdateProductRequest request);
    // List<ProductResponse> toProductResponseList(List<Product> products);

    default String mapStatus(Product product)  {
        return product.getStatus() ? ACTIVE_STATUS : INACTIVE_STATUS;
    }

}

// 1:10:25 visto