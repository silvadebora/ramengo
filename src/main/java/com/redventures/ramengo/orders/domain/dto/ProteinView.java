package com.redventures.ramengo.orders.domain.dto;

import java.math.BigDecimal;

public class ProteinView {

    private Long id;
    private String imageInactive;
    private String imageActive;
    private String name;
    private String description;
    private BigDecimal price;

    public ProteinView() {
    }

    public ProteinView(Long id, String imageInactive, String imageActive, String name, String description, BigDecimal price) {
        this.id = id;
        this.imageInactive = imageInactive;
        this.imageActive = imageActive;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageActive() {
        return imageActive;
    }

    public void setImageActive(String imageActive) {
        this.imageActive = imageActive;
    }

    public String getImageInactive() {
        return imageInactive;
    }

    public void setImageInactive(String imageInactive) {
        this.imageInactive = imageInactive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}




