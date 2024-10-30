package com.photon.product_service.service;

import com.photon.product_service.dto.ProductsResponse;
import com.photon.product_service.entity.Product;
import com.photon.product_service.exception.ProductNotFoundException;
import com.photon.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductsService {

    private final ProductRepository productRepository;

    public ProductsResponse getAllProducts() {
        return ProductsResponse.builder().build();
    }

    public Product getProduct(String id) throws ProductNotFoundException {
        log.info("Request to fetch product: " + id);
        Optional<Product> response = productRepository.findById(id);
        if (response.isPresent()) {
            log.info("Product details: " + response.get());
            return response.get();
        }

        throw new ProductNotFoundException(id);
    }
}
