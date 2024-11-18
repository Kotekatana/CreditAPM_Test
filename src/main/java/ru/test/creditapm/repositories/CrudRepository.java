package ru.test.creditapm.repositories;

import java.util.List;

public interface CrudRepository<T> {

    void save (T entity);

    List<T> findAll();

    T findById(Long id);
}
