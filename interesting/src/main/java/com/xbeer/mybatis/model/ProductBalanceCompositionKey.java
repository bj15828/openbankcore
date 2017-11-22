package com.xbeer.mybatis.model;

public class ProductBalanceCompositionKey {
    private String productId;

    private String balaCompId;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getBalaCompId() {
        return balaCompId;
    }

    public void setBalaCompId(String balaCompId) {
        this.balaCompId = balaCompId == null ? null : balaCompId.trim();
    }
}