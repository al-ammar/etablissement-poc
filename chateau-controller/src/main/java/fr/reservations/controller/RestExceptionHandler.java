package fr.reservations.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ NullPointerException.class })
	public ResponseEntity<Object> handleTechnicalException() {
		return new ResponseEntity<>("", new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
}
