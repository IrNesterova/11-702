package ru.itis.services;

import ru.itis.forms.AddProductsForm;

public interface ProductService {
    void addProduct(AddProductsForm form);
    void removeProduct();
    void updateProduct();
}
