package com.photon.product_service;

import com.photon.product_service.dto.ProductsResponse;
import com.photon.product_service.entity.Product;
import com.photon.product_service.exception.ProductNotFoundException;
import com.photon.product_service.resource.ProductsResource;
import com.photon.product_service.service.ProductsService;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

@SpringBootTest
class ProductServiceApplicationTests {

}
