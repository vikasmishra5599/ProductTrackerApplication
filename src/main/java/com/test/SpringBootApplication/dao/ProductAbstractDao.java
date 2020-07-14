package com.test.SpringBootApplication.dao;

import com.test.SpringBootApplication.dao.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductAbstractDao extends JpaRepository<Product, Long>, ProductDao {}