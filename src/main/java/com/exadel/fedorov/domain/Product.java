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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }
}
