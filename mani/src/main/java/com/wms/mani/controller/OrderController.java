package com.wms.mani.controller;

import com.wms.mani.Model.Order;
import com.wms.mani.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order createOrder(
            @RequestParam Long productId,
            @RequestParam int quantity) {
        return orderService.createOrder(productId, quantity);
    }

    @PutMapping("/{id}/status")
    public Order updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return orderService.updateStatus(id, status);
    }

    @GetMapping
    public List<Order> getAllOrder() {
        return orderService.getAllOrders();
    }
}
