package ru.itis.services;

import ru.itis.forms.AddProductsForm;
import ru.itis.models.Product;
import ru.itis.repositories.CartRepository;
import ru.itis.repositories.ProductsRepository;

public class ProductServiceImpl implements ProductService{
    ProductsRepository productsRepository;
    public ProductServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }


    @Override
    public void addProduct(AddProductsForm addProductsForm) {
        Product newProduct = Product.builder()
                .title(addProductsForm.getTitle())
                .image(addProductsForm.getImage())
                .description(addProductsForm.getDescription())
                .price(addProductsForm.getPrice().toString())
                .slug(addProductsForm.getSlug())
                .created_at(addProductsForm.getCreated_at())
                .stock(addProductsForm.getStock())
                .build();
    productsRepository.save(newProduct);
    }

    @Override
    public void removeProduct() {

    }

    @Override
    public void updateProduct() {

    }
}
