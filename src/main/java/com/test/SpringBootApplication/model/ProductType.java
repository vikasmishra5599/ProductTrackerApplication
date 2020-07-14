package com.test.SpringBootApplication.model;

import java.util.Arrays;

public enum ProductType {
    PHONE("phone"),
    SUBSCRIPTION("subscription");

    private String value;

    ProductType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean contains(String value) {
        return Arrays.stream(values())
                .map(ProductType::getValue)
                .anyMatch(type -> type.equalsIgnoreCase(value));
    }
}
