package com.springboot.exceptions;

import com.springboot.models.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GenericExceptions.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseModel handleGenericExceptions(GenericExceptions gex) {
        return new ResponseModel(ResponseModel.FAILURE, gex.getResponseMessage());
    }
}
