package com.inttao.npi.backend.util.service;

import java.util.Optional;

public interface ServiceWithName<E> {
    Optional<E> getByName(String name);
}
