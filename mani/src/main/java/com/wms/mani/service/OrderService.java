package com.wms.mani.service;

import com.wms.mani.Model.Order;
import com.wms.mani.Model.Product;
import com.wms.mani.repo.OrderRepository;
import com.wms.mani.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service

public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

           //For Creating New Order(naya order k liya)
    public Order createOrder(Long productId, int quantity) {
        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found "));
        Order order = new Order();
        order.setOrderNumber("ORD-" + System.currentTimeMillis());
        order.setStatus("Pending");
        order.setProduct(product);
        order.setQuantity(quantity);
        order.setCreatedAt(LocalDateTime.now());
        return orderRepository.save(order);
    }
        // For Updating The Order Status
        @Transactional
                public Order updateStatus(Long orderId, String newStatus){
            Order order = orderRepository
                    .findById(orderId)
                    .orElseThrow(() -> new RuntimeException("Order not found"));
// if stock is packed so minius kro stock
            if(newStatus.equals("Packed")){
                Product product = order.getProduct();
                if(product.getQuantity()< order.getQuantity()){
                    throw new RuntimeException("Insufficient Stock !");
                }
                product.setQuantity(
                        product.getQuantity() - order.getQuantity()
                );
                productRepository.save(product);
            }
            order.setStatus(newStatus);
return orderRepository.save(order);
        }
        //TO See All Orders
    public List<Order>getAllOrders(){
        return orderRepository.findAll();
    }
}
