package com.photon.order_service.resource;

import com.photon.order_service.dto.OrderRequest;
import com.photon.order_service.entity.Order;
import com.photon.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderResource {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody OrderRequest request) {
        try {
            return ResponseEntity.ok(orderService.createOrder(request));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
