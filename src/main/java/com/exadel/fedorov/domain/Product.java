package com.exadel.fedorov.domain;

public class Product {

    private Long id;
    private String title;
    private String name;
    private Integer cost;
    private Integer categoryId;
    private Integer manufacturerId;

    public Product(Long id, String title, String name, Integer cost, Integer categoryId, Integer manufacturerId) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.cost = cost;
        this.categoryId = categoryId;
        this.manufacturerId = manufacturerId;
    }
}
