package com.inttao.npi.backend.util.service;

import java.util.List;

public interface ICrudService<DTO, ID> {
    DTO get(ID id);
    List<DTO> getAll();
    DTO create(DTO d);
    DTO update(ID id, DTO d);
    DTO save(DTO dto);
    void delete(ID id);

    List<DTO> search(String searchCriteria);

}
