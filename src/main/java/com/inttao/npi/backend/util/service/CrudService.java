package com.inttao.npi.backend.util.service;

import com.inttao.npi.backend.util.domain.AbstractEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.repository.CrudRepository;


import java.util.*;

public interface CrudService <T extends AbstractEntity, I> extends ICrudService<T, I>{

	CrudRepository<T, I> getRepository();

	default T get(I id) {
		return load(id);
	}
	default T create(T e) {
		return save(e);
	}
	default T update(I id, T e) {
		return save(e);
	}
	default T save(T entity) {
		return getRepository().save(entity);
	}
	default void delete(T entity)  {
		if (entity == null)
			throw new EntityNotFoundException();
		getRepository().delete(entity);
	}
	default void delete(I id) {
		delete(load(id));
	}

	default long count() {
		return getRepository().count();
	}

	default T load(I id) {
		T entity = getRepository().findById(id).orElse(null);
			if (entity == null)
				throw new EntityNotFoundException("Cannot find entity - " + id);
		return entity;
	}

	default List<T> getAll()
	{
		List<T> ret = new ArrayList<>();
		for (T t : getRepository().findAll())
			ret.add(t);
		return ret;
	}
	T createNew();
	default Iterable<T> saveAll(Iterable<T> entities) {
		return getRepository().saveAll(entities);
	}

	default List<T> search(String query) {
		return getAll();
	}
}
