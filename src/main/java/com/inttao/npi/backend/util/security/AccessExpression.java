package com.inttao.npi.backend.util.security;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Modela una expresion logica de acceso mediante Authority (strings)
 *
 * Posee 2 listas:
 *  - DenyAuthorities: si el principal posee algun Authority de esta lista, inmediatamente deny
 *  - AllowAuthorities: segunda face de autorizacion, accede si algun Authority del principal se encuentra en esta lista
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessExpression implements Serializable {
    private Set<String> denyAuthorities = new HashSet<>();
    private Set<String> allowAuthorities = new HashSet<>();

}
