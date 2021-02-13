package com.exadel.fedorov.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "brands")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Brand() {
    }

    public Brand(String name) {
        this.name = name;
    }

    public Brand(Long id, String brand) {
        this.id = id;
        this.name = brand;
    }
}
