package com.example.smartPos.repositories;

import com.example.smartPos.repositories.model.Sale;
import com.example.smartPos.repositories.model.SalesReturn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesReturnRepository extends JpaRepository<SalesReturn, Integer> {
    List<SalesReturn> findBySale_SaleId(Integer saleId);

    List<SalesReturn> findBySale_SaleIdIn(List<Integer> saleIds);

    List<SalesReturn> findByCustomerId(Integer customerId);

    @Query("SELECT sr FROM SalesReturn sr")
    List<SalesReturn> findAllWithCustomer();

    @Query("SELECT TO_CHAR(s.returnDate, 'YYYY-MM') AS month, SUM(s.refundAmount) " +
            "FROM SalesReturn s " +
            "GROUP BY TO_CHAR(s.returnDate, 'YYYY-MM')")
    List<Object[]> findMonthlySaleReturns();

    @Query("SELECT SUM(s.refundAmount) FROM SalesReturn s")
    Double findTotalSalesReturns();

    @Query("SELECT COALESCE(SUM(sr.quantityReturned * b.unitCost), 0.0) " +
            "FROM SalesReturn sr " +
            "JOIN SaleProduct sp ON sr.sale.saleId = sp.sale.saleId " +
            "JOIN Product p ON sr.product.productId = p.productId " +
            "JOIN Batch b ON sp.batchNo = b.batchNumber AND p.sku = b.sku " +
            "WHERE sr.product.productId = sp.product.productId")
    Double findTotalSalesReturnCOGS();

    @Query("SELECT TO_CHAR(sr.returnDate, 'YYYY-MM') AS month, " +
            "SUM(sr.quantityReturned * b.unitCost) AS totalCOGS " +
            "FROM SalesReturn sr " +
            "JOIN SaleProduct sp ON sr.sale.saleId = sp.sale.saleId " +
            "JOIN Product p ON sr.product.productId = p.productId " +
            "JOIN Batch b ON sp.batchNo = b.batchNumber AND p.sku = b.sku " +
            "WHERE sr.product.productId = sp.product.productId " +
            "GROUP BY TO_CHAR(sr.returnDate, 'YYYY-MM')")
    List<Object[]> findMonthlySalesReturnCOGS();
}