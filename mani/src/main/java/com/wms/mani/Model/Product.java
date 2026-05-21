package com.wms.mani.Model;
import jakarta.persistence.*;
import lombok.Data;
               //Product Entity for wms
@Data
@Entity
@Table(name= "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String name;
private String sku;
@Column(unique = true)
private String barcode;
private int quantity;
private double price;


@ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;
}
