package com.inttao.npi.backend.util.exceptions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation is used to define the error code that will be returned
 * in the response when an exception is thrown.
 *
 * <p>
 *     La motivación de esta anotación es poder definir el código de error que se retornará
 *     en la respuesta cuando se lance una excepción.
 *     <br>
 *     Luego poder escanear las excepciones, agregarlas a un Map dinámico y obtener el código de error definido en la anotación.
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ExceptionMessageErrorCode {
    String errorCode();
}
