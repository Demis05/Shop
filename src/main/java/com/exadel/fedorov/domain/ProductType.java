package com.exadel.fedorov.domain;

import java.util.Arrays;
import java.util.List;

public enum ProductType {

    PHONE("phone"),
    LAPTOP("laptop"),
    MONO_BLOCK("mono_block");

    private final String name;

    ProductType(String name) {
        this.name = name;
    }

    public static List<ProductType> getProductTypes() {
        return Arrays.asList(values());
    }

    public String getName() {
        return name;
    }
}