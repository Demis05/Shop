package com.exadel.fedorov.domain;

import java.util.Arrays;
import java.util.List;

public enum ProductType {

    PHONE("phone"),
    LAPTOP("laptop"),
    MONO_BLOCK("mono_block");

    private final String type;

    ProductType(String type) {
        this.type = type;
    }

    public static List<ProductType> getProductTypes() {
        return Arrays.asList(values());
    }

    public String getType() {
        return type;
    }
}