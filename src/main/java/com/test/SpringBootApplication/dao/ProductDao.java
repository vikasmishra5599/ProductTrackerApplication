package com.test.SpringBootApplication.dao;

import com.test.SpringBootApplication.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product, Long> {

}
