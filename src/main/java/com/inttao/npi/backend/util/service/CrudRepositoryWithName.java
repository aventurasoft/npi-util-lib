package com.inttao.npi.backend.util.service;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CrudRepositoryWithName<T, I>  extends CrudRepository<T, I> {
    Optional<T> findByName(String name);


}
