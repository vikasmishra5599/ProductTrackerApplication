package com.test.SpringBootApplication.service;

import com.test.SpringBootApplication.dao.ProductDao;
import com.test.SpringBootApplication.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }


    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
         productDao.findAll().forEach(product -> products.add(product));
         return products;

    }
}
