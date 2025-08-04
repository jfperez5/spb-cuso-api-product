package com.caneksoft.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorResponse {

    private String code;
    private HttpStatus status;
    private String message;
    private List<String> deteilMessages;
    private LocalDateTime timeStamp;
}
