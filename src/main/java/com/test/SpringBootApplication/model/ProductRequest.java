package com.test.SpringBootApplication.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class ProductRequest {

    private ProductType type;
    private Number min_price;
    private Number max_price;
    private String city;
    private String color;
    private Number gb_limit_min;
    private Number gb_limit_max;

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public Number getMin_price() {
        return min_price;
    }

    public void setMin_price(Number min_price) {
        this.min_price = min_price;
    }

    public Number getMax_price() {
        return max_price;
    }

    public void setMax_price(Number max_price) {
        this.max_price = max_price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Number getGb_limit_min() {
        return gb_limit_min;
    }

    public void setGb_limit_min(Number gb_limit_min) {
        this.gb_limit_min = gb_limit_min;
    }

    public Number getGb_limit_max() {
        return gb_limit_max;
    }

    public void setGb_limit_max(Number gb_limit_max) {
        this.gb_limit_max = gb_limit_max;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
