package com.inttao.npi.backend.util.service;

import com.inttao.npi.backend.util.EntityMapper;
import com.inttao.npi.backend.util.domain.AbstractEntity;
import com.inttao.npi.backend.util.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface CrudServiceDTO <E extends AbstractEntity<ID>, DTO, ID>  {
    CrudService<E, ID> getService();
    EntityMapper<DTO, E> getMapper();

    default DTO get(ID id) {
        E entity = getService().load(id);
        return getMapper().toDto(entity);
    }
    default List<DTO> getAll() {
        List<E> response = getService().getAll().stream().toList();
        return getMapper().toDto(response);
    }

    default DTO create(DTO e) {
        E entity = getMapper().toEntity(e);
        entity.setNew(true);
        entity =  getService().save(entity);
        return getMapper().toDto(entity);
    }

    default DTO update(ID id, DTO e) {

        E entity = getService().load(id);
        if (entity == null)
            throw new ResourceNotFoundException("Resource not found: " + id);
        getMapper().partialUpdate(entity, e);
        entity = getService().save(entity);
        return getMapper().toDto(entity);

    }
    default void delete(ID id) {
        getService().delete(id);

    }

    default DTO save(DTO e) {
        E entity = getService().save(getMapper().toEntity(e));

        return getMapper().toDto(entity);
    }
    default List<DTO> search(String search) {
        return this.getAll();
    }



}
