package com.compasso.service.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardException> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		StandardException exception = new StandardException(
				System.currentTimeMillis(), 
				HttpStatus.NOT_FOUND.value(), 
				"Não encontrado", 
				e.getMessage(), 
				request.getRequestURI()
			);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
	}
}
