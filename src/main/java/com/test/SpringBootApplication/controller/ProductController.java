package com.test.SpringBootApplication.controller;

import com.test.SpringBootApplication.entity.Product;
import com.test.SpringBootApplication.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {

    private ProductService productService;

     @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("products")
    public List<Product> getProducts() {
      return productService.getAllProducts();
    }
}
