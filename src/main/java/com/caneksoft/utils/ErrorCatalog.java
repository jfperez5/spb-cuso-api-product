package com.caneksoft.utils;

import lombok.Getter;

@Getter
public enum ErrorCatalog {

    PRODUCT_NOT_FOUND("ERR_PROD_001", "Product not found."),
    INVALID_PRODUCT("ERR_PROD_002", "Invalid product parameters."),
    PRODUCT_ALREADY_EXISTS("PRODUCT_ALREADY_EXISTS", "Product already exists"),
    CATEGORY_NOT_FOUND("ERR_CAT_001", "Category not found."),
    CATEGORY_ALREADY_EXISTS("CATEGORY_ALREADY_EXISTS", "Category already exists"),
    GENERIC_ERROR("ERR_GEN_001", "An unexpected error occurred. Please try again later.");

private final String code;
private final String message;

ErrorCatalog(String code, String message){
    this.code = code;
    this.message = message;
}

}



// 2:10:00 EXPLICACIÓN 