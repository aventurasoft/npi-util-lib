package com.inttao.npi.backend.util.service;


import com.inttao.npi.backend.util.exceptions.EntityAPINotFoundException;
import com.inttao.npi.backend.util.controller.IController;
import com.inttao.npi.backend.util.domain.HasId;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import java.util.List;

@Log4j2
public abstract class AbstractCrudServiceApiClient<DTO extends HasId<ID>, ID> implements ICrudService<DTO,ID> {

    public abstract IController<DTO, ID> getApi();

    protected boolean verifyResponse(ResponseEntity<?> response) {
        if (!response.hasBody()) {
            log.error("Entity not found");
            throw new EntityAPINotFoundException("API response error - " + response.getStatusCode().toString(), response.getStatusCode());
        }
        return true;
    }

    @Override
    public DTO get(ID id) {
        ResponseEntity<DTO> response = getApi().get(id);
        verifyResponse(response);
        return response.getBody();
    }

    @Override
    public List<DTO> getAll() {
        ResponseEntity<List<DTO>> response = getApi().getAll();
        verifyResponse(response);
        return response.getBody();
    }

    @Override
    public DTO create(DTO d) {
        ResponseEntity<DTO> response = getApi().create(d);
        verifyResponse(response);
        return response.getBody();
    }

    @Override
    public DTO update(ID id, DTO d) {
        ResponseEntity<DTO> response = getApi().update(id, d);
        verifyResponse(response);
        return response.getBody();
    }

    @Override
    public void delete(ID id) {
        getApi().delete(id);
    }

    @Override
    public List<DTO> search(String search) {
        if (search == null || search.isEmpty())
            return getAll();
        ResponseEntity<List<DTO>> response = getApi().search(search);
        verifyResponse(response);
        return response.getBody();
    }


    public DTO save(DTO dto) {
        if (dto != null && dto.getId() != null) {

            ResponseEntity<DTO> response = getApi().update(dto.getId(), dto);
            verifyResponse(response);
            return response.getBody();
        } else {
            ResponseEntity<DTO> response = getApi().create(dto);
            verifyResponse(response);
            return response.getBody();
        }
    }
}
