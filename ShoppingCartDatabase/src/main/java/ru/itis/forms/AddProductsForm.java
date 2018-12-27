package ru.itis.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.sql.Timestamp;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductsForm {
    private String title;
    private String slug;
    private String description;
    private Integer price;
    private String image;
    private int stock;
    private Timestamp created_at;
    private Timestamp updated_at;
}
