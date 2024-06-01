package com.redventures.ramengo.orders.services.impl;

import com.redventures.ramengo.orders.domain.dto.BrothView;
import com.redventures.ramengo.orders.repositories.BrothRepository;
import com.redventures.ramengo.orders.services.IBrothService;
import com.redventures.ramengo.orders.util.BrothConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrothService implements IBrothService {

    @Autowired
    private BrothRepository brothRepository;

    @Override
    public List<BrothView> listBroths() {
        var broths = brothRepository.findAll();
        return broths.stream().map(BrothConverter::toView).collect(Collectors.toList());
    }
}
