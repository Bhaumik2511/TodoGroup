package com.example.TodoGroup.Exception;

public class TodoGroupException {

	private int errorCode;
    private String message;
    
	public TodoGroupException() {
		
	}
	
	public TodoGroupException(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
