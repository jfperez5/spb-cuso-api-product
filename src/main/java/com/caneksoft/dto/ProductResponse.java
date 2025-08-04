package com.caneksoft.dto;

import java.math.BigDecimal;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
// @JsonInclude(JsonInclude.Include.NON_NULL) se declara mejor en el aplication properties para no hacerlo clase a clase
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private CategoryResponse category;
    private String status;

}
