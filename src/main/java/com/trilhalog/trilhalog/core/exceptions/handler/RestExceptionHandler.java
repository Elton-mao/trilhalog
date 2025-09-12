package com.trilhalog.trilhalog.core.exceptions.handler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.dao.DataIntegrityViolationException;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.trilhalog.trilhalog.core.exceptions.custom.TransportadoraNotFoundException;
import com.trilhalog.trilhalog.core.exceptions.custom.UsuarioNotFoundException;
import com.trilhalog.trilhalog.core.exceptions.dto.ApiError;

@RestControllerAdvice
public class RestExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> genericException(Exception ex) {
		ApiError error = new ApiError(
				LocalDateTime.now(), 
				HttpStatus.NOT_FOUND.value(),
				HttpStatus.NOT_FOUND.name(),
				List.of(ex.getMessage()));
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler({
		UsuarioNotFoundException.class,
		TransportadoraNotFoundException.class
	}
	)
	public ResponseEntity<ApiError> NotFoundException(RuntimeException ex) {
		ApiError error = new ApiError(
				LocalDateTime.now(),
				HttpStatus.NOT_FOUND.value(),
				HttpStatus.NOT_FOUND.name(),
				List.of(ex.getMessage()));
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(
			MethodArgumentNotValidException.class
			)
	public ResponseEntity<ApiError> argumentNotValidException(MethodArgumentNotValidException ex){
		List<String> errorList = ex.getBindingResult().getFieldErrors()
					.stream()
					.map(error ->error.getDefaultMessage())
					.collect(Collectors.toList());
		ApiError apiError = new ApiError(
				LocalDateTime.now(), 
				HttpStatus.BAD_REQUEST.value(),
				HttpStatus.BAD_REQUEST.name(),
				errorList);
		
		return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);	
	}
	

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ApiError> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
	    String rootMessage = ex.getRootCause() != null ? ex.getRootCause().getMessage() : ex.getMessage();

	    String friendlyMessage;

	    if (rootMessage.contains("uq_doca_horario")) {
	        friendlyMessage = "Já existe um slot para esta doca nesta data e horário!";
	    } else if (rootMessage.contains("FOREIGN KEY")) {
	        friendlyMessage = "A doca informada não existe.";
	    } else if (rootMessage.contains("cannot be null")) {
	        friendlyMessage = "Um campo obrigatório está nulo: " + rootMessage;
	    } else {
	        friendlyMessage = "Erro de integridade no banco: " + rootMessage;
	    }

	    ApiError apiError = new ApiError(
	            LocalDateTime.now(),
	            HttpStatus.BAD_REQUEST.value(),
	            HttpStatus.BAD_REQUEST.name(),
	            List.of(friendlyMessage)
	    );

	    return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
	}

	
	
}
