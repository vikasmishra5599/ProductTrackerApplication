package com.test.SpringBootApplication.model;

import com.test.SpringBootApplication.dao.entity.Product;

import java.util.List;

public class ProductResponse {
    private List<Product> data;

    public ProductResponse(List<Product> data) {
        this.data = data;
    }

    public List<Product> getData() {
        return data;
    }
}
