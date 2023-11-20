package com.app.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApiException {


//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
//        Object object = new Object();
//        object.setStatus(HttpStatus.BAD_REQUEST);
//        object.setMessage("Invalid request");
//        object.setErrors(e.getBindingResults().getFieldErrors());
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(object);
//    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        Map<String ,String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(objectError -> {
            String fieldName= ((FieldError) objectError).getField();
            String errorMassage = objectError.getDefaultMessage();
            errors.put(fieldName,errorMassage);
        });
        return new ResponseEntity<Object>(errors,HttpStatus.BAD_REQUEST);
    }
}
