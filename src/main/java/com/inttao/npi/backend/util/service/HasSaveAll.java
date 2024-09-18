package com.inttao.npi.backend.util.service;

import java.util.Iterator;

public interface HasSaveAll <E, PARENTID> {
    E save (E entity);
    Iterable<E> saveAll(PARENTID parentId, Iterable<E> entities);
}
