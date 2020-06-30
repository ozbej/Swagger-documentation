package com.test.example;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> exception(Exception ex, WebRequest request) {
		
		String errorMessage = ex.getLocalizedMessage();
		
		if(errorMessage == null) errorMessage = ex.toString();
		
		ErrorMessage em = new ErrorMessage(new Date(), errorMessage);
		
	    return new ResponseEntity<>(ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
