package com.inttao.npi.backend.util.controller;

import com.inttao.npi.backend.util.domain.AbstractEntity;
import com.inttao.npi.backend.util.service.CrudServiceDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface ICrudControllerUsingService<E extends AbstractEntity<ID>, DTO, ID>  {
    CrudServiceDTO<E, DTO, ID> getService();


    default ResponseEntity<DTO> get(ID id) {
        try {
            DTO entity = getService().get(id);
            return ResponseEntity.ok(entity);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    default ResponseEntity<List<DTO>> getAll() {
        List<DTO> response = getService().getAll().stream().toList();
        return ResponseEntity.ok(response);
    }

    default ResponseEntity<DTO> create(DTO e) {
        DTO entity = getService().create(e);
        return ResponseEntity.ok(entity);
    }

    default ResponseEntity<DTO> update(ID id, DTO e) {
        try {
            DTO entity = getService().update(id, e);
            if (entity == null)
                return ResponseEntity.notFound().build();
            return ResponseEntity.ok(entity);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.ok(getService().create(e));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }
    default void delete(ID id) {
        getService().delete(id);

    }

    default DTO save(DTO e) {
        return getService().save(e);
    }

    default ResponseEntity<List<DTO>> search(String search) {
        return this.getAll();
    }


}
