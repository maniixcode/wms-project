package com.wms.mani.controller;

import com.wms.mani.Model.Product;
import com.wms.mani.service.ReceivingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/receiving")
public class ReceivingController {

@Autowired
    private ReceivingService receivingService;
@PostMapping("/shipment")
public Product receiveshipment(
        @RequestParam Long productId,
        @RequestParam int quantity,
        @RequestParam Long binId){
    return receivingService
            .receiveShipment(productId, quantity, binId);
}
}
