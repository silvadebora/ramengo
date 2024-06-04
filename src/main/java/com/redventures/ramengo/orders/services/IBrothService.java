package com.redventures.ramengo.orders.services;

import com.redventures.ramengo.orders.domain.dto.BrothView;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBrothService {

    List<BrothView> listBroths();
    ResponseEntity saveBroth(Object broth);
}
