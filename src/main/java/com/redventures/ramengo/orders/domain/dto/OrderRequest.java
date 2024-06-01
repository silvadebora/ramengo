package com.redventures.ramengo.orders.domain.dto;

import com.redventures.ramengo.orders.domain.Broth;
import com.redventures.ramengo.orders.domain.Protein;
import jakarta.validation.constraints.NotEmpty;

public class OrderRequest {

    @NotEmpty(message = "insert broth id")
    private Broth brothId;

    @NotEmpty(message = "insert protein id")
    private Protein proteinId;

    public OrderRequest(Broth brothId, Protein proteinId) {
        this.brothId = brothId;
        this.proteinId = proteinId;
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
}
