package in.microservice.marketingmanagermicroservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = NoDataFoundException.class)
	public ResponseEntity<Object> noDataFoundException(NoDataFoundException exception) {
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> otherExceptions(Exception ex) {
		return new ResponseEntity<Object>(ex, HttpStatus.BAD_REQUEST);
	}
}
