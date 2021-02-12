package com.exadel.fedorov.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String title;
    private String name;
    private Integer cost;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ProductType type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    public Product() {
    }

    public Product(Long id, String title, String name, Integer cost, ProductType productType, Brand brand) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.cost = cost;
        this.type = productType;
        this.brand = brand;
    }
}
