package ru.itis.repositories;

import ru.itis.models.Cart;
import ru.itis.models.Product;

import java.util.List;
import java.util.Map;

public interface CartRepository extends CrudRepository<Cart> {
    Cart findByOwnerId(Long ownerId);
    List<Product> getProductList(Cart cart);
    void addProduct(Cart cart, Product product);
    void deleteProductFromCart(Cart cart, Product product);
    Map<Product,Integer> toMap(List<Product> productList);
}
