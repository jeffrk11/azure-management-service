package com.socialsoul.base.exception;

import java.time.LocalDateTime;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.socialsoul.base.model.ErrorMessage;

@ControllerAdvice
public class ControllerAdvisor {
    
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ErrorMessage> handlerTechnicalException(EmptyResultDataAccessException e){
        return new ResponseEntity<>(new ErrorMessage(LocalDateTime.now().toString(), 
                                                        e.getMessage()),
                                                        HttpStatus.NOT_FOUND);
    }  
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorMessage> handlerBusinessException(BusinessException e){
        return new ResponseEntity<>(new ErrorMessage(LocalDateTime.now().toString(), 
                                                        e.getMessage()),
                                                        e.getStatus());
    }   
}
