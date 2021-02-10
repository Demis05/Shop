package com.exadel.fedorov.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String name;
    private Integer cost;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ProductType type;

    @Column(name = "manufacturer_id")
    private Integer manufacturerId;

    public Product() {
    }

    public Product(Long id, String title, String name, Integer cost, ProductType productType, Integer manufacturerId) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.cost = cost;
        this.type = productType;
        this.manufacturerId = manufacturerId;
    }
}
