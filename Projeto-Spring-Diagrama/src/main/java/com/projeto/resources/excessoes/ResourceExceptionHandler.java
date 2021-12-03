package com.projeto.resources.excessoes;

import com.projeto.services.excessoes.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){

        return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new StandardError(HttpStatus.NOT_FOUND.value(),
                        e.getMessage(),
                        System.currentTimeMillis()));
    }
}
