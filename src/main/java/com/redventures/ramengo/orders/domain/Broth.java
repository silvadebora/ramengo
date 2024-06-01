package com.redventures.ramengo.orders.domain;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "broths")
public class Broth {

    @Id
    private String id;
    private String imageInactive;
    private String imageActive;
    private String name;
    private String description;
    private BigDecimal price;

    public Broth() {
    }

    public Broth(String id) {
        this.id = id;
    }

    public Broth(String id, String imageInactive, String imageActive, String name, String description, BigDecimal price) {
        this.id = id;
        this.imageInactive = imageInactive;
        this.imageActive = imageActive;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageInactive() {
        return imageInactive;
    }

    public void setImageInactive(String imageInactive) {
        this.imageInactive = imageInactive;
    }

    public String getImageActive() {
        return imageActive;
    }

    public void setImageActive(String imageActive) {
        this.imageActive = imageActive;
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
