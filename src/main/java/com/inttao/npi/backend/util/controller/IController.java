package com.inttao.npi.backend.util.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IController<T, ID> {
    @GetMapping(path = "/{id}")
    ResponseEntity<T> get(@PathVariable("id") ID id);

    @GetMapping(path = "")
    ResponseEntity<List<T>> getAll();

    @PostMapping("")
    ResponseEntity<T> create(@RequestBody T e);

    @PutMapping("/{id}")
    ResponseEntity<T> update(@PathVariable("id") ID id, @RequestBody T e);

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") ID id);

    @GetMapping("/search/{searchCriteria}")
    ResponseEntity<List<T>> search(@PathVariable("searchCriteria") String searchCriteria);


}
