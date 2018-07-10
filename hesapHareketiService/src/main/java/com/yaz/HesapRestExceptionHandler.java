package com.yaz;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HesapRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<HesapErrorResponse> handleException(HesapNotFoundException exc){
		
		HesapErrorResponse error = new HesapErrorResponse(
				HttpStatus.NOT_FOUND.value(),
				exc.getMessage(),
				System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<HesapErrorResponse> handleException(Exception exc){
		
		HesapErrorResponse error = new HesapErrorResponse(
				HttpStatus.BAD_REQUEST.value(),
				exc.getMessage(),
				System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	
}
