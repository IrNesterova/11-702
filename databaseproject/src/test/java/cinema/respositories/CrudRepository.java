package cinema.respositories;

import java.util.List;

public interface CrudRepository<T, V> {
    void create(T model);
    void update(T model);
    void delete(V id);
    T findOne(V id);
    List<T> findAll();
}
