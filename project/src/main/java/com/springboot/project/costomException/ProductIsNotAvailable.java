package com.springboot.project.costomException;

public class ProductIsNotAvailable extends RuntimeException {
    public ProductIsNotAvailable(String message) {
        super(message);
    }

}
