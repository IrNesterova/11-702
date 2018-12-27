package ru.itis.repositories;

import ru.itis.models.Product;

import java.util.Optional;

public interface ProductsRepository extends CrudRepository<Product, Long> {
    Optional<Product> findByPrice(String price);
}
