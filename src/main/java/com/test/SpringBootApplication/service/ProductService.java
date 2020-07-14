package com.test.SpringBootApplication.service;

import com.test.SpringBootApplication.dao.ProductAbstractDao;
import com.test.SpringBootApplication.dao.entity.Product;
import com.test.SpringBootApplication.model.ProductRequest;
import com.test.SpringBootApplication.model.ProductResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.size;

@Service
public class ProductService {

    private static final Logger LOG = LoggerFactory.getLogger(ProductService.class);
    private ProductAbstractDao productAbstractDao;

    @Autowired
    public ProductService(ProductAbstractDao productAbstractDao) {
        this.productAbstractDao = productAbstractDao;
    }

    public ProductResponse findAllProducts() {
        return new ProductResponse(productAbstractDao.findAll());
    }

    public ProductResponse findProducts(ProductRequest request) {
        List<Product> results = productAbstractDao.findProductBasedOnFilter(request);

        LOG.info("Request processed successfully and found [{}] product for request [{}] ", size(results), request);
        return new ProductResponse(results);
    }
}