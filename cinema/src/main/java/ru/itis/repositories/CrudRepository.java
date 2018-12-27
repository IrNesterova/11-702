package ru.itis.repositories;

import java.util.List;

public interface CrudRepository<T> {
    void save(T model);
    void update(T model);
    void delete(Long id);
    T findOne(Long id);
    List<T> findAll();
}
