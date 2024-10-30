package com.photon.product_service.resource;

import com.photon.product_service.Fixtures;
import com.photon.product_service.dto.ProductsResponse;
import com.photon.product_service.entity.Product;
import com.photon.product_service.exception.ProductNotFoundException;
import com.photon.product_service.service.ProductsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ProductsResourceTest {
    ProductsResource productsResource;

    @Mock
    ProductsService productsService;

    @BeforeEach
    public void setup() {
        productsResource = new ProductsResource(productsService);
    }

    @Test
    public void shouldReturnAllProducts() {
        // Given
        List<Product> productList = Fixtures.getMockProductList();
        ProductsResponse expectedResponse = ProductsResponse.builder().productList(productList).build();

        // When
        Mockito.when(productsService.getAllProducts()).thenReturn(expectedResponse);

        ResponseEntity<ProductsResponse> actualResponse = productsResource.getAll();
        Assertions.assertNotNull(actualResponse);
        Assertions.assertEquals(expectedResponse.productList.size(), actualResponse.getBody().productList.size());
    }

    @Test
    public void shouldReturnProductById() throws ProductNotFoundException {
        // Given
        Product expectedResponse = Fixtures.getMockProduct();
        String productId = UUID.randomUUID().toString();

        // When
        Mockito.when(productsService.getProduct(productId)).thenReturn(expectedResponse);

        ResponseEntity<Product> actualResponse = productsResource.get(productId);
        Assertions.assertNotNull(actualResponse);
        Assertions.assertEquals(expectedResponse, actualResponse.getBody());
    }

    @Test
    public void shouldThrowProductNotFoundException() throws ProductNotFoundException {
        // Given
        Product expectedResponse = Fixtures.getMockProduct();
        String productId = UUID.randomUUID().toString();

        // When
        Mockito.doThrow(ProductNotFoundException.class).when(productsService.getProduct(productId));

        Assertions.assertThrows(ProductNotFoundException.class, () -> productsResource.get(productId));
    }
}