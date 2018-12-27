package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {
    private Long id;
    private User owner;
    private Map<Product, Integer> productsCount = new HashMap<>();

    public void add(Product product){
        productsCount.put(product, productsCount.getOrDefault(product, 0) + 1);
    }

    public void deleteProduct(Product product){
        if (productsCount.getOrDefault(product, 0) == 1){
            productsCount.remove(product);
        } else if (productsCount.getOrDefault(product, 0) > 1){
            productsCount.put(product, productsCount.getOrDefault(product, 0) - 1);
        }
    }
}
