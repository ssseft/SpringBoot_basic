package com.mysite.bbs.contact;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "entity not found")
public class DatanotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DatanotFoundException(String message) {
        super(message);
    }
}