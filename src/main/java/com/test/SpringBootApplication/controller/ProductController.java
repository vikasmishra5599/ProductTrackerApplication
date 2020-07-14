package com.test.SpringBootApplication.controller;

import com.test.SpringBootApplication.model.ProductRequest;
import com.test.SpringBootApplication.model.ProductResponse;
import com.test.SpringBootApplication.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.test.SpringBootApplication.controller.RequestProcessor.validateAndMapToRequest;

@RestController
@RequestMapping("/")
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public ResponseEntity healthCheck() {
        LOG.info("Received request to show complete product list");
        return ResponseEntity.ok("Application is running fine.");
    }

    @GetMapping("products")
    public ProductResponse getProducts() {
        LOG.info("Received request to show complete product list");
        return productService.findAllProducts();
    }

    @GetMapping("product")
    public ProductResponse getProduct(@RequestParam(required = false) String type,
                                      @RequestParam(required = false) Number min_price,
                                      @RequestParam(required = false) Number max_price,
                                      @RequestParam(required = false) String city,
                                      @RequestParam(required = false) String color,
                                      @RequestParam(required = false) Number gb_limit_min,
                                      @RequestParam(required = false) Number gb_limit_max) {
        LOG.info("Received request to get product based on criteria");

        ProductRequest request = validateAndMapToRequest(type, min_price, max_price, city, color, gb_limit_min, gb_limit_max);

        LOG.info("Product request [{}]", request);
        return productService.findProducts(request);
    }

    @ExceptionHandler({IllegalArgumentException.class,})
    public ResponseEntity handleIllegalArgumentException(IllegalArgumentException exception) {
        LOG.warn("An illegal argument found in request", exception);
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity handleException(Exception ex) {
        LOG.error("An error occurred while processing request", ex);
        return ResponseEntity.status(500).build();
    }

}