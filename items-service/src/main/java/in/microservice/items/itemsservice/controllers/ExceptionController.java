package in.microservice.items.itemsservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import in.microservice.items.itemsservice.exceptions.ItemNotFoundException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = ItemNotFoundException.class)
	public ResponseEntity<Object> throwItemNotFoundException(
			ItemNotFoundException e) {
		return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
