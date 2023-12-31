package com.facturacion.commons;

import com.facturacion.web.ResponseError;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExeptionHandler {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseError> handleValidateExceptions(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<String, String>();
    ex.getBindingResult().getAllErrors().forEach((error)-> {
            String fieldName = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
    return ResponseError.ErrorResponse(HttpStatus.BAD_REQUEST, "Petición Erronea", errors);
    }

    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(JDBCConnectionException.class)
    public ResponseEntity<ResponseError> handleDBExceptions(JDBCConnectionException ex){

        return ResponseError.ErrorResponse(HttpStatus.BAD_REQUEST, "Error en la BD", "No se conectó correctamente con la Base de Datos");
    }
    

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseError> handleResourceNotFoundException(ResourceNotFoundException ex)
    {
        return ResponseError.ErrorResponse( HttpStatus.NOT_FOUND, "No se encontró el recurso", ex.getMessage()) ;
    }
}

