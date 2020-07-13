package com.test.SpringBootApplication.enricher;

import com.opencsv.CSVReader;
import com.test.SpringBootApplication.entity.Product;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ReadFromCSVUtil {

    public static List<Product> readFromCSVFile(String fileName) throws Exception {
        Reader reader = Files.newBufferedReader(Paths.get(
                ClassLoader.getSystemResource(fileName).toURI()));

        CSVReader csvReader = new CSVReader(reader);
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

            product.setProductType(productRow[0]);

            String property = productRow[1];
            String[] propertyDetails = property.split(":");
            product.setPropertyType(propertyDetails[0]);
            product.setPropertyValue(propertyDetails[1]);

            product.setPrice(Double.parseDouble(productRow[2]));
            product.setPriceType("Min");
            product.setAddress(productRow[3]);
        }
        return product;
    }
}
