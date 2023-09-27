package com.francodev.springboottutorialmio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> globalExceptionHandler(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
//        error.put("error :", ex.getMessage());
//        return error;
     ex.getBindingResult()
               .getFieldErrors()
               .forEach(error -> errors.put("message", error.getDefaultMessage()));
      return errors;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(GlobalNotFoundException.class)
    public  Map<String, String> DepartmentNotFoundException(GlobalNotFoundException ex){
        Map<String, String> error = new HashMap<>();
        error.put("message", ex.getMessage());
        return error;
    }
}
