package com.photon.product_service;

import com.photon.product_service.entity.Product;

import java.util.List;
import java.util.UUID;

public class Fixtures {

    public static List<Product> getMockProductList() {
        String productId = UUID.randomUUID().toString();
        return List.of(Product.builder()
                .id(productId)
                .name("Product Name")
                .description("Product Desc")
                .imageUrl("www.someproduct.com/products/" + productId)
                .build());
    }

    public static Product getMockProduct() {
        String productId = UUID.randomUUID().toString();
        return Product.builder()
                .id(productId)
                .name("Product Name")
                .description("Product Desc")
                .imageUrl("www.someproduct.com/products/" + productId)
                .build();
    }
}
