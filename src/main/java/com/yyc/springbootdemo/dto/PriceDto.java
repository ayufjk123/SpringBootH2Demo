package com.yyc.springbootdemo.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Objeto de resultado que devuelve
 * */
public class PriceDto {

    private String productId;
    private Integer priceList;

    private Integer brandId;

    private BigDecimal price;

    private Date applicationDate;

    private String msgError;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getPriceList() {
        return priceList;
    }

    public void setPriceList(Integer priceList) {
        this.priceList = priceList;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }

    @Override
    public String toString() {
        return "PriceDto{" +
                "productId='" + productId + '\'' +
                ", priceList=" + priceList +
                ", brandId=" + brandId +
                ", price=" + price +
                ", applicationDate=" + applicationDate +
                '}';
    }
}
