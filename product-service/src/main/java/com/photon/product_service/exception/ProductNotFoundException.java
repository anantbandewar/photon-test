package com.photon.product_service.exception;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String productId) {
        super("Product not found: " + productId);
    }
}
