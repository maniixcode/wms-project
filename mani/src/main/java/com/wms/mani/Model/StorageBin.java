package com.wms.mani.Model;
import jakarta.persistence.*;
import lombok.Data;


    @Data
    @Entity
    @Table(name = "storage_bins")

    public class StorageBin {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String binCode;
        private String zone;
        private String aisle;
        private int capacity;
        private int currentStock;

        @ManyToOne
        @JoinColumn(name = "warehouse_id")
        private Warehouse warehouse;

}
