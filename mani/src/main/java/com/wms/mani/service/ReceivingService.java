package com.wms.mani.service;

import com.wms.mani.Model.Product;
import com.wms.mani.Model.StorageBin;
import com.wms.mani.repo.StorageBinRepository;
import com.wms.mani.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class ReceivingService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StorageBinRepository storageBinRepository;

    @Transactional
    public Product receiveShipment(Long productId, int quantity, Long binId){

        //step one: For Product Search

        Product product = productRepository
                .findById(productId)
                .orElseThrow(()->
                        new RuntimeException("Product not found"));

                //step 2 Stock incre decre (Update)
        product.setQuantity(product.getQuantity() + quantity);

        //step 3 bin assign
        StorageBin bin = storageBinRepository
                .findById(binId)
                .orElseThrow(()->
                        new RuntimeException("Bin not found"));
        bin.setCurrentStock(bin.getCurrentStock() + quantity);
        // step 4 Save Data
        storageBinRepository.save(bin);
        return productRepository.save(product);
    }
}
