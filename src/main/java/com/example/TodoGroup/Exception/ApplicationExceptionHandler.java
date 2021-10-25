package com.example.TodoGroup.Exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {
	
	private static final String CONNECTION_MESSAGE ="http://localhost:8082 server is down.";
	
	private static final String EMPTYDATA_MESSAGE ="Not record found for requested group id.";
	
	
	
	@ExceptionHandler(java.net.ConnectException.class)
    public ResponseEntity<TodoGroupException> handleConnectionException(Exception e){
		TodoGroupException todoGroupException = new TodoGroupException(503, CONNECTION_MESSAGE);
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(todoGroupException);
    }
    
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<TodoGroupException> handleEmptyResultSetException(Exception e){
		TodoGroupException todoGroupException = new TodoGroupException(204, EMPTYDATA_MESSAGE);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(todoGroupException);
    }
}
