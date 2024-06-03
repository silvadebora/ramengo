package com.redventures.ramengo.orders.domain.dto;

import java.math.BigDecimal;

public class OrderView {
    private Long id;
    private String description;
    private String image;
    private BigDecimal amount;

    public OrderView() {
    }

    public OrderView(Long id, String description, String image, BigDecimal amount) {
        this.id = id;
        this.description = description;
        this.image = image;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
