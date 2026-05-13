package com.example.smartPos.repositories;

import com.example.smartPos.repositories.model.PurchaseReturn;
import com.example.smartPos.repositories.model.SalesReturn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseReturnRepository extends JpaRepository<PurchaseReturn, Integer> {
    List<PurchaseReturn> findByPurchase_PurchaseId(Integer purchaseId);

    @Query("SELECT pr FROM PurchaseReturn pr JOIN Supplier s ON pr.supplierId = s.supId")
    List<PurchaseReturn> findAllWithSupplier();

    @Query("SELECT pr FROM PurchaseReturn pr WHERE pr.purchase.purchaseId IN :purchaseIds")
    List<PurchaseReturn> findByPurchaseIds(@Param("purchaseIds") List<Integer> purchaseIds);

    List<PurchaseReturn> findBySupplierId(Integer supplierId);

    @Query("SELECT TO_CHAR(p.returnDate, 'YYYY-MM') AS month, SUM(p.refundAmount) " +
            "FROM PurchaseReturn p " +
            "GROUP BY TO_CHAR(p.returnDate, 'YYYY-MM')")
    List<Object[]> findMonthlyPurchaseReturns();

    @Query("SELECT SUM(p.refundAmount) FROM PurchaseReturn p")
    Double findTotalPurchaseReturns();
}
