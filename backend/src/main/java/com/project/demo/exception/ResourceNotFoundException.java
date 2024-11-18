package com.project.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//custom exception
@ResponseStatus(HttpStatus.NOT_FOUND) //returns HTTP 404 (Not Found) when resource is not found
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    } //calls parent's constructor (RuntimeException) with the specified message
}
