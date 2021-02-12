package com.exadel.fedorov.dto;

import lombok.Data;

@Data
public class ProductDto {

    private Long id;
    private String title;
    private String name;
    private Integer cost;
    private String category;
    private String brand;

    public ProductDto() {
    }

    public ProductDto(Long id, String title, String name, Integer cost, String category, String brand) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.cost = cost;
        this.category = category;
        this.brand = brand;
    }
}
