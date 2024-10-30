package com.photon.product_service.resource;

import com.photon.product_service.dto.ProductsResponse;
import com.photon.product_service.entity.Product;
import com.photon.product_service.exception.ProductNotFoundException;
import com.photon.product_service.service.ProductsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductsResource {

    private final ProductsService productsService;

    @GetMapping
    public ResponseEntity<ProductsResponse> getAll() {
        return ResponseEntity.ok(productsService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable String id) throws ProductNotFoundException {
        return ResponseEntity.ok(productsService.getProduct(id));
    }
}
