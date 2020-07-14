package com.test.SpringBootApplication.controller;

import com.test.SpringBootApplication.model.ProductRequest;
import com.test.SpringBootApplication.model.ProductType;

import static java.util.Objects.nonNull;
import static org.hibernate.query.criteria.internal.ValueHandlerFactory.isNumeric;

public class RequestProcessor {

    public static ProductRequest validateAndMapToRequest(String type, Number min_price,
                                                         Number max_price, String city,
                                                         String color, Number gb_limit_min,
                                                         Number gb_limit_max) {
        ProductRequest request = new ProductRequest();

        if (nonNull(type)) {
            if (ProductType.contains(type)) {
                request.setType(ProductType.valueOf(type.toUpperCase()));
            } else {
                throw new IllegalArgumentException("product type requested is not supported");
            }
        }

        if (nonNull(min_price) && isNumeric(min_price)) {
            request.setMin_price(min_price);
        }

        if (nonNull(max_price) && isNumeric(max_price)) {
            request.setMax_price(max_price);
        }

        if (nonNull(gb_limit_min) && isNumeric(gb_limit_min)) {
            request.setGb_limit_min(gb_limit_min);
        }

        if (nonNull(gb_limit_max) && isNumeric(gb_limit_max)) {
            request.setGb_limit_max(gb_limit_max);
        }

        request.setCity(city);
        request.setColor(color);

        return request;
    }
}
