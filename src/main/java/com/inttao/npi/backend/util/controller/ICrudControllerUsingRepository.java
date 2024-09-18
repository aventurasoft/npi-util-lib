package com.inttao.npi.backend.util.controller;


import com.inttao.npi.backend.util.EntityMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ICrudControllerUsingRepository<E, DTO, ID>  {
    JpaRepository<E, ID> getRepository();
    EntityMapper<DTO, E> getMapper();


    default ResponseEntity<DTO> get(ID id) {
        Optional<E> context = getRepository().findById(id);
        if (!context.isPresent())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(getMapper().toDto(context.get()));
    }

    default ResponseEntity<List<DTO>> getAll() {
        List<E> contextDTOS = getRepository().findAll();
        return ResponseEntity.ok(getMapper().toDto(contextDTOS));
    }

    default ResponseEntity<DTO> create(DTO e) {
        E newContext = getRepository().save(getMapper().toEntity( e));

        return ResponseEntity.ok(getMapper().toDto(newContext));
    }

    default ResponseEntity<DTO> update(ID id, DTO e) {
        Optional<E> context = getRepository().findById(id);
        if (!context.isPresent())
            return  ResponseEntity.notFound().build();
        E c = context.get();
        getMapper().partialUpdate(c, e );
        c = getRepository().save(c);
        return ResponseEntity.ok(getMapper().toDto(c));
    }
    default void delete(ID id) {
        getRepository().deleteById(id);

    }

    default ResponseEntity<List<DTO>> search(String search) {
        return this.getAll();
    }
}
