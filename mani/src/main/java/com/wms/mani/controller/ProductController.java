package com.wms.mani.controller;

import com.wms.mani.Model.Product;
import com.wms.mani.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/products")

public class ProductController {
    @Autowired
    private ProductRepository productRepo;

    @GetMapping
    public List<Product>getAll(){
        return productRepo.findAll();
    }
  @PostMapping
  public Product create(@RequestBody Product p)  {
        return productRepo.save(p);
  }
  @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        productRepo.deleteById(id);
  }
    @GetMapping("/hello")
    public String hello() {
        return "WMS Product API Runing Successfully";
    }
}
