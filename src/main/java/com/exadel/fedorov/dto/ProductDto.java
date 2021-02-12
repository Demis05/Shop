package com.exadel.fedorov.dto;

import lombok.Data;

@Data
public class ProductDto {

    private Long id;
    private String title;
    private String name;
    private Integer cost;
    private String type;
    private String brand;

    public ProductDto() {
    }

    public ProductDto(Long id, String title, String name, Integer cost, String type, String brand) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.cost = cost;
        this.type = type;
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public Integer getCost() {
        return cost;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }
}
