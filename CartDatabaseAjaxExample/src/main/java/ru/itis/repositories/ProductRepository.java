package ru.itis.repositories;

import ru.itis.models.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product> {
    Product findByName(String name);
    List<Product> findByAllTitleSearch(String table);

}
