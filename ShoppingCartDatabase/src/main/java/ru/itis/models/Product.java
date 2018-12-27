package ru.itis.models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.sql.Timestamp;


@Data
@Builder
public class Product{
    public Long id;
    public String title;
    public String slug;
    public String description;
    public String price;
    public String image;
    public Integer stock;
    public Timestamp created_at;
    public Timestamp updated_at;
    public Cart cart;
}
