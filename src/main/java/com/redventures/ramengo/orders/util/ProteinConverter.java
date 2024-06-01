package com.redventures.ramengo.orders.util;


import com.redventures.ramengo.orders.domain.Protein;
import com.redventures.ramengo.orders.domain.dto.ProteinView;

public class ProteinConverter {

    public static ProteinView toView(Protein protein){
        return new ProteinView(protein.getId(), protein.getDescription(), protein.getName(),
                protein.getImageActive(), protein.getImageInactive(), protein.getPrice());
    }
    public static Protein toEntity(ProteinView protein){
        return new Protein(protein.getId(), protein.getDescription(), protein.getName(),
                protein.getImageInactive(), protein.getImageInactive(), protein.getPrice());
    }

}
