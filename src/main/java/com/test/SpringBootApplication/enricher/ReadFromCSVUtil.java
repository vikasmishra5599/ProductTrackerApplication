package com.test.SpringBootApplication.enricher;

import com.opencsv.CSVReader;
import com.test.SpringBootApplication.dao.entity.Product;

import org.springframework.core.io.ClassPathResource;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import static com.test.SpringBootApplication.model.PropertyType.COLOR;
import static com.test.SpringBootApplication.model.PropertyType.GB_LIMIT;
import static java.util.Objects.isNull;

public class ReadFromCSVUtil {

    public static List<Product> readFromCSVFile(String fileName) throws Exception {
        InputStreamReader inputStreamReader = new InputStreamReader(
                new ClassPathResource(fileName).getInputStream());
        CSVReader csvReader = new CSVReader(inputStreamReader);

        return mapToProducts(csvReader.readAll());
    }

    private static List<Product> mapToProducts(List<String[]> productLines) {
        return productLines.stream()
                .map(productRow -> mapToProduct(productRow))
                .collect(Collectors.toList());
    }

    private static Product mapToProduct(String[] productRow) {
        Product product = new Product();
        for (int i = 0; i < productRow.length; i++) {

            product.setType(productRow[0]);

            setProperties(productRow[1], product);

            product.setPrice(Double.parseDouble(productRow[2]));
            product.setAddress(productRow[3]);
        }
        return product;
    }

    private static void setProperties(String property, Product product) {
        String[] propertyDetails = property.split(":");
        String propertyType = propertyDetails[0];
        String propertyValue = propertyDetails[1];

        if (isNull(propertyType) || isNull(propertyValue)) {
            return;
        }

        if (COLOR.getValue().equalsIgnoreCase(propertyType)) {
            product.setColor(propertyValue);
        }

        if (GB_LIMIT.getValue().equalsIgnoreCase(propertyType)) {
            product.setGblimit(Integer.parseInt(propertyValue));
        }
    }
}