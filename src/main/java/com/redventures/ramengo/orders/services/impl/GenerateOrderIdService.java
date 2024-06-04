package com.redventures.ramengo.orders.services.impl;

import com.redventures.ramengo.orders.services.IGenerateOrderIdService;
import com.redventures.ramengo.orders.util.OrderIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GenerateOrderIdService implements IGenerateOrderIdService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${generate.api.url}")
    private String apiUrl;

    @Value("${api.key}")
    private String apiKey;

    @Override
    public String generateOrderId() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", apiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<OrderIdResponse> response =
                restTemplate.exchange(apiUrl, HttpMethod.POST,
                        entity, OrderIdResponse.class);

        return response.getBody().getOrderId();
    }
}
