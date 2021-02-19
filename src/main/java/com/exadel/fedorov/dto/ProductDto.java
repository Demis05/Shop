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
    private String imagePath;

    public ProductDto() {
    }
}
