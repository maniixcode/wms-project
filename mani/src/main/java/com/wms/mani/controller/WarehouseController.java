package com.wms.mani.controller;

import com.wms.mani.Model.Warehouse;
import com.wms.mani.repo.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/warehouses")

public class WarehouseController {

    @Autowired
    private WarehouseRepository warehouseRepo;

    @GetMapping
    public List<Warehouse> getAll(){
        return warehouseRepo.findAll();
    }
    @PostMapping
    public Warehouse create(@RequestBody Warehouse w ){
        return warehouseRepo.save(w);
    }
    @PutMapping("/{id}")
    public Warehouse update(@PathVariable Long id,
                            @RequestBody Warehouse w){
        w.setId(id);
        return warehouseRepo.save(w);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        warehouseRepo.deleteById(id);
    }

}
