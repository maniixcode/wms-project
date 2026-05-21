package com.wms.mani.repo;

import com.wms.mani.Model.StorageBin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StorageBinRepository
extends JpaRepository<StorageBin, Long> {


}
