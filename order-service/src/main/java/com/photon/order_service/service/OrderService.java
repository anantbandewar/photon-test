package com.photon.order_service.service;

import com.photon.order_service.dto.OrderRequest;
import com.photon.order_service.entity.Order;
import com.photon.order_service.entity.Product;
import com.photon.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final RestTemplate restTemplate;

    public Order createOrder(OrderRequest request) throws Exception {
        if (checkProductAvailability(request.getOrderDetails()))
            return orderRepository.save(request.getOrderDetails());
        else
            throw new Exception("Invalid payload");
    }

    private boolean checkProductAvailability(Order orderDetails) {
        List<String> products = orderDetails.getProducts();

        for (String productId : products) {
            try {
                restTemplate.getForObject("localhost:8081/products/" + productId, Product.class);

            } catch (Exception e) {
                log.error(e.getLocalizedMessage());
                return false;
            }
        }
        return true;
    }
}
