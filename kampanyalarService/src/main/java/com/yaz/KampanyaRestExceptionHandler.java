package com.yaz;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class KampanyaRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<KampanyaErrorResponse> handleException(KampanyaNotFoundException exc){
		
		KampanyaErrorResponse error = new KampanyaErrorResponse(
				HttpStatus.NOT_FOUND.value(),
				exc.getMessage(),
				System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<KampanyaErrorResponse> handleException(Exception exc){
		
		KampanyaErrorResponse error = new KampanyaErrorResponse(
				HttpStatus.BAD_REQUEST.value(),
				exc.getMessage(),
				System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	
}
