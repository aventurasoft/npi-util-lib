package com.inttao.npi.backend.util.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

@Getter
@Setter
public class EntityAPINotFoundException extends RuntimeException{
    protected HttpStatusCode statusCode;
    public EntityAPINotFoundException() {
        super();
    }
    public EntityAPINotFoundException(String mensaje) {
        super(mensaje);
    }

    public EntityAPINotFoundException(String mensaje, HttpStatusCode statusCode) {
        super(mensaje);
        this.statusCode = statusCode;
    }
}
