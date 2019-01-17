package com.sb.hml.homeworklog.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class HWCustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		HWExceptionResponse exResp = new HWExceptionResponse(ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(exResp,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(StudentNotFoundException.class)
	public final ResponseEntity<Object> handleAllExceptions(StudentNotFoundException ex, WebRequest request) throws Exception {
		HWExceptionResponse exResp = new HWExceptionResponse(ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(exResp,HttpStatus.NOT_FOUND);
	}
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		HWExceptionResponse exResp = new HWExceptionResponse(ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(exResp,HttpStatus.BAD_REQUEST);
	}

	

}
