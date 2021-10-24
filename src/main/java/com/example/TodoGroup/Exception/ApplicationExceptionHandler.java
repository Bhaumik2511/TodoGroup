package com.example.TodoGroup.Exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {
	
	@Value("${todoItem.url}")
	private static final String MESSAGE ="http://localhost:8082 server is down.";
	
	
	@ExceptionHandler(java.net.ConnectException.class)
    public ResponseEntity<TodoGroupException> handleGenericException(Exception e){
		TodoGroupException todoGroupException = new TodoGroupException(503, MESSAGE);
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(todoGroupException);
    }
}
