package com.test.SpringBootApplication.enricher;

import com.test.SpringBootApplication.dao.ProductAbstractDao;
import com.test.SpringBootApplication.dao.entity.Product;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.test.SpringBootApplication.enricher.ReadFromCSVUtil.readFromCSVFile;

@Component
public class ProductDBLoadRunner implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(ProductDBLoadRunner.class);
    private ProductAbstractDao productAbstractDao;

    @Autowired
    public ProductDBLoadRunner(ProductAbstractDao productAbstractDao) {
        this.productAbstractDao = productAbstractDao;
    }

    @Override
    public void run(String... args) {
        LOG.info("Starting loading data from csv file into database");
        try {
            List<Product> products = readFromCSVFile("data.csv");

            products.forEach(product -> productAbstractDao.save(product));

            int size = CollectionUtils.size(productAbstractDao.findAll());
            LOG.info("Record save in DB count [{}]", size);
        } catch (Exception e) {
            LOG.warn("An error occurred while saving record in Db", e);
        }
    }
}
