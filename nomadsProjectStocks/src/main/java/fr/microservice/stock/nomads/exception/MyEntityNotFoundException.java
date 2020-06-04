package fr.microservice.stock.nomads.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MyEntityNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MyEntityNotFoundException() {
		super();
	}

	public MyEntityNotFoundException(String message) {
		super(message);
	}
	
	public MyEntityNotFoundException(Throwable cause) {
		super(cause);
	}

	public MyEntityNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public MyEntityNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
