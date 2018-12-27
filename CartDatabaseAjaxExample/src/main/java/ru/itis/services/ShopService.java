package ru.itis.services;

import ru.itis.models.Cart;
import ru.itis.models.Product;

import javax.servlet.http.Cookie;
import java.util.List;

public interface ShopService {

    Cart buy(Long productId, Cookie[] cookies, LoginService loginService);
    Cart getUserCart(LoginService loginService, Cookie[] cookies);
    Cart deleteFromCart(Long productId, Cookie[]cookies, LoginService loginService);


}
