package com.redventures.ramengo.orders.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
@Entity
@Table(name = "orders")
public class Order {

    public static final String DEFAULT_IMAGE = "https://tech.redventures.com.br/icons/ramen/ramenChasu.png";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private List<String> description;
    private String image;
    @OneToOne
    private Broth brothId;
    @OneToOne
    private Protein proteinId;
    private BigDecimal amount;


    public Order() {
    }

    public Order(Broth brothId, Protein proteinId) {
        this.brothId = brothId;
        this.proteinId = proteinId;
    }

    public Order(Long id, List<String> description, String image, Broth brothId, Protein proteinId, BigDecimal amount) {
        this.id = id;
        this.description = description;
        this.image = image;
        this.brothId = brothId;
        this.proteinId = proteinId;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    public String getImage() {
        return DEFAULT_IMAGE;
    }

    public void setImage(String DEFAULT_IMAGE) {
        this.image = DEFAULT_IMAGE;
    }

    public Broth getBrothId() {
        return brothId;
    }

    public void setBrothId(Broth brothId) {
        this.brothId = brothId;
    }

    public Protein getProteinId() {
        return proteinId;
    }

    public void setProteinId(Protein proteinId) {
        this.proteinId = proteinId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
