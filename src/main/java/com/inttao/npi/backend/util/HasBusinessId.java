package com.inttao.npi.backend.util;

/**
 * Interfaz que modela clases que poseen identificador de negocio
 * Se entiende por identificador de negocio los ids publicos reconocidos por los usuarios
 * que se diferencian de los IDs internos de persistencia.
 * Por ejemplo:
 *      Curve posee un id de persistencia Long y un businessId que es un numero del modelo RAROC
 *
 */
public interface HasBusinessId {
    /**
     * Devuelve el identificador de negocio
     * Por simplicidad siempre es un String y dependera de la clase si el mismo es originalmente otro tipo
     * de datos
     * @return
     */
    String getBusinessId();
}
