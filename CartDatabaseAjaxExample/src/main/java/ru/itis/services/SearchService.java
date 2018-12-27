package ru.itis.services;

import ru.itis.models.Product;

import java.util.List;

public interface SearchService {
    public List<Product> search(String title);
}
