package ru.itis.userscrud.dao;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<ID, V> {
    Optional<V> find(ID id);
    List<V> findAll();
    V save(V entity);
    boolean delete(ID id);
    boolean update(V entity);
}
