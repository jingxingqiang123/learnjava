package com.demo.common;

import com.demo.response.BaseResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public BaseResponse apiExceptionHandler(Exception ex) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(403);
        baseResponse.setMessage(ex.getMessage());
        return baseResponse;
    }
}
