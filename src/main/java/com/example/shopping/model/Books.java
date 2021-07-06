package com.example.shopping.model;

import com.example.shopping.enums.Categories;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String bookName;
    private String categories;
    private Double price;
    private Integer inStock;
    private Integer sku;
    private String description;
    private String imageUrl;

}
