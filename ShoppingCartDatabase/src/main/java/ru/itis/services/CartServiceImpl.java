package ru.itis.services;

import ru.itis.models.Product;
import ru.itis.repositories.CartRepository;
import ru.itis.repositories.ProductsRepository;
import ru.itis.repositories.UsersRepository;

public class CartServiceImpl implements CartService {
    CartRepository cartRepository;


    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;

    }

    @Override
    public void addToCart() {

    }
}
