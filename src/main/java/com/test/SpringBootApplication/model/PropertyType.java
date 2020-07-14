package com.test.SpringBootApplication.model;

public enum PropertyType {
    COLOR("color"),
    GB_LIMIT("gb_limit");

    private String value;

    PropertyType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}