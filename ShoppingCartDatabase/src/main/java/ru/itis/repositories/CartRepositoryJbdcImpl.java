package ru.itis.repositories;

import ru.itis.models.Product;

import java.sql.Connection;

public class CartRepositoryJbdcImpl{
    Connection connection;
    //language=sql
    private static final String SQL_FIND_BY_ID = "" +
            "select * from orders where id = ?";
    //language=sql
    private static final String SQL_UPDATE_CART =
            "update orders set product_id = ?, quantity = ?, total = ?," +
                    "address_id = ?, paid = ?, customer_id = ?, updated_at = ?";
    //language=sql
    private static final String SQL_INSERT_CART =
            "insert into orders (product_id, quantity, total, address_id, paid, customer_id, created_at) VALUES(?,?,?,?,?,?,?)";



}