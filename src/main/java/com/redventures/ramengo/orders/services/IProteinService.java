package com.redventures.ramengo.orders.services;


import com.redventures.ramengo.orders.domain.dto.ProteinView;

import java.util.List;

public interface IProteinService {

    List<ProteinView> listProteins();
}
