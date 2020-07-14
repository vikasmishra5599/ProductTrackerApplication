package com.test.SpringBootApplication.dao;

import com.test.SpringBootApplication.dao.entity.Product;
import com.test.SpringBootApplication.model.ProductRequest;

import java.util.List;

public interface ProductDao {
    List<Product> findProductBasedOnFilter(ProductRequest productRequest);
}
