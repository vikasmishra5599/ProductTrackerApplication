package com.test.SpringBootApplication.enricher;

import com.test.SpringBootApplication.dao.ProductDao;
import com.test.SpringBootApplication.entity.Product;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.test.SpringBootApplication.enricher.ReadFromCSVUtil.readFromCSVFile;

@Component
public class ProductDBLoadRunner implements CommandLineRunner {
    private ProductDao productDao;

    @Autowired
    public ProductDBLoadRunner(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void run(String... args) {
        try {
            List<Product> products = readFromCSVFile("data.csv");
            products.forEach(product -> productDao.save(product));
            int size = CollectionUtils.size(productDao.findAll());
            System.out.println("Size of product"+size);

        } catch (Exception e) {

            System.out.println("Failed to save record");

        }
    }

}
