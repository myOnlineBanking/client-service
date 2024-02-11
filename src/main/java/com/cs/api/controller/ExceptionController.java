package com.cs.api.controller;

import com.cs.api.entity.ErrorClass;
import com.cs.api.exceptions.UserException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorClass> handleChequeException(UserException ex, HttpServletRequest request) {
        logger.error("User Service Error" , ex);
        return ResponseEntity.status(ex.getStatus()).body(new ErrorClass(ex.getStatus(), ex.getMessage(), request.getRequestURI()));
    }

}
