package com.wms.mani.repo;
import com.wms.mani.Model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface WarehouseRepository
 extends JpaRepository<Warehouse,Long> {

    }


