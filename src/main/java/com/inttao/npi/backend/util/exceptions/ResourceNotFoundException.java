package com.inttao.npi.backend.util.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@ExceptionMessageErrorCode(errorCode = "ResourceNotFoundException")
public class ResourceNotFoundException extends  RuntimeException {
    public ResourceNotFoundException(String message){
        super(message);
    }
}
