package ru.itis.services;

import ru.itis.models.Product;
import ru.itis.repositories.ProductRepository;

import java.util.List;

public class SearchServiceImpl implements SearchService {
    private ProductRepository productRepository;

    public SearchServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> search(String title) {
        return productRepository.findByAllTitleSearch(title);
    }
}
