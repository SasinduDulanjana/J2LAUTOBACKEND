package com.example.smartPos.repositories;

import com.example.smartPos.repositories.model.ProductBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductBatchRepository extends JpaRepository<ProductBatch, Integer> {

    ProductBatch findByPurchaseIdAndProduct_ProductId(Integer purchaseId, Integer productId);

    List<ProductBatch> findByPurchaseId(Integer purchaseId);

    List<ProductBatch> findByBatch_BatchNumber(String batchNo);
}
