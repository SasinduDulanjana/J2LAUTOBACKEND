package com.example.smartPos.controllers.responses;

import lombok.Data;

import java.util.List;

@Data
public class ProductListOfBatchResponse extends CommonResponse {
    private Integer purchaseId;

    private String batchNumber;

    private List<ProductBatchResponse> productBatchResponses;

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public List<ProductBatchResponse> getProductBatchResponses() {
        return productBatchResponses;
    }

    public void setProductBatchResponses(List<ProductBatchResponse> productBatchResponses) {
        this.productBatchResponses = productBatchResponses;
    }
}
