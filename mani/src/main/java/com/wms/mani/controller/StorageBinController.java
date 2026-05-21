package com.wms.mani.controller;

import com.wms.mani.Model.StorageBin;
import com.wms.mani.repo.StorageBinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bins")

public class StorageBinController {

    @Autowired
    private StorageBinRepository binRepo;

    @GetMapping
    public List<StorageBin>getAll(){
        return binRepo.findAll();
    }
    @PostMapping
    public StorageBin create(@RequestBody StorageBin bin){
        return binRepo.save(bin);
    }
    @PutMapping("/{id}")
    public StorageBin update(@PathVariable Long id,
                             @RequestBody StorageBin bin){
        bin.setId(id);
        return binRepo.save(bin);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        binRepo.deleteById(id);
    }
}
