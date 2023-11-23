package com.diplomado.userservice.exception;

import com.diplomado.userservice.api.response.CommonResponse;
import com.diplomado.userservice.api.response.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
  
  @ExceptionHandler( value = { BadRequestException.class })
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<CommonResponse> badRequestException (BadRequestException ex){
    return new ResponseEntity<>( new CommonResponse("401", ex.getMessage()),
    new HttpHeaders(),
    HttpStatus.BAD_REQUEST
    );
  }
  
  @ExceptionHandler({ApplicationException.class})
  public ResponseEntity<ErrorResponse> handleApplicationException(ApplicationException source,
                                                                  WebRequest request) {
    ErrorResponse errorInfo = new ErrorResponse( "402", source.getMessage(),
    ((ServletWebRequest) request ).getRequest().getRequestURI());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorInfo);
  }
  
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });
    return errors;
  }
  
  
}
