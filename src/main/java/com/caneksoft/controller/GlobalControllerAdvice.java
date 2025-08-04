package com.caneksoft.controller;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.context.support.DefaultMessageSourceResolvable;

import com.caneksoft.dto.ErrorResponse;
import com.caneksoft.exceptions.CategoryNotFoundException;
import com.caneksoft.exceptions.ProductNotFoundException;

import static com.caneksoft.utils.ErrorCatalog.PRODUCT_NOT_FOUND;
import static com.caneksoft.utils.ErrorCatalog.CATEGORY_NOT_FOUND;
import static com.caneksoft.utils.ErrorCatalog.GENERIC_ERROR;
import static com.caneksoft.utils.ErrorCatalog.INVALID_PRODUCT;


@RestControllerAdvice
public class GlobalControllerAdvice {

@ResponseStatus(HttpStatus.NOT_FOUND)
@ExceptionHandler(ProductNotFoundException.class)
public ErrorResponse handleProductNotFoundException(){
    return ErrorResponse.builder()
           .code(PRODUCT_NOT_FOUND.getCode())
           .status(HttpStatus.NOT_FOUND)
           .message(PRODUCT_NOT_FOUND.getMessage())
           .timeStamp(LocalDateTime.now())
           .build();
}

@ResponseStatus(HttpStatus.NOT_FOUND)
@ExceptionHandler(CategoryNotFoundException.class)
public ErrorResponse handleCategoryNotFoundException(){
    return ErrorResponse.builder()
           .code(CATEGORY_NOT_FOUND.getCode())
           .status(HttpStatus.NOT_FOUND)
           .message(CATEGORY_NOT_FOUND.getMessage())
           .timeStamp(LocalDateTime.now())
           .build();
}

// Bad Request
@ResponseStatus(HttpStatus.BAD_REQUEST)
@ExceptionHandler(MethodArgumentNotValidException.class)
public ErrorResponse handleMethodArgumentNotValidException(
    MethodArgumentNotValidException exception){
    BindingResult result = exception.getBindingResult();
        return ErrorResponse.builder()
           .code(INVALID_PRODUCT.getCode())
           .status(HttpStatus.BAD_REQUEST)
           .message(INVALID_PRODUCT.getMessage())
           .deteilMessages(result.getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList()))
           .timeStamp(LocalDateTime.now())
           .build();
}

// Error Generico
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@ExceptionHandler(Exception.class)
public ErrorResponse handleGenericException(Exception exception) {
    return ErrorResponse.builder()
           .code(GENERIC_ERROR.getCode())
           .status(HttpStatus.INTERNAL_SERVER_ERROR)
           .message(GENERIC_ERROR.getMessage())
           .timeStamp(LocalDateTime.now())
           .build();
}

}


// 2:26:28 https://www.youtube.com/watch?v=N0NMWYl8wYk