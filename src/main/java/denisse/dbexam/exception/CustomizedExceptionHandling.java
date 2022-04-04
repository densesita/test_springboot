package denisse.dbexam.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedExceptionHandling extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmailException.class)
	public ResponseEntity<Object> handleExceptions(EmailException exception, WebRequest webRequest) {
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setStatus("ERROR");
		response.setMessage(exception.getExceptionMessage());
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.OK);
		return entity;
	}

	@ExceptionHandler(PasswordException.class)
	public ResponseEntity<Object> handleExceptions(PasswordException exception, WebRequest webRequest) {
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setStatus("ERROR");
		response.setMessage(exception.getExceptionMessage());
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.OK);
		return entity;
	}
}
