package com.caneksoft.mapper;

import org.mapstruct.Mapper;

import com.caneksoft.dto.CategoryResponse;
import com.caneksoft.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryResponse toCategoryResponse(Category category);
}
