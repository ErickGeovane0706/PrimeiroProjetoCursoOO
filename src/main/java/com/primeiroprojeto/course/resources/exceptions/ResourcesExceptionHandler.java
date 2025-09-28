package com.primeiroprojeto.course.resources.exceptions;

import com.primeiroprojeto.course.services.exceptions.DataBaseException;
import com.primeiroprojeto.course.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;


@ControllerAdvice
public class ResourcesExceptionHandler{
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError>resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String erro="Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err= new StandardError(Instant.now(),status.value(),erro,e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardError>dataBase(DataBaseException e, HttpServletRequest request){
        String erro="Data Base Error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err= new StandardError(Instant.now(),status.value(),erro,e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
