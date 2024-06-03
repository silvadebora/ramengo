package com.redventures.ramengo.orders.service;

import com.redventures.ramengo.orders.domain.Broth;
import com.redventures.ramengo.orders.domain.Order;
import com.redventures.ramengo.orders.domain.Protein;
import com.redventures.ramengo.orders.exception.BrothNotFoundException;
import com.redventures.ramengo.orders.exception.ProteinNotFoundException;
import com.redventures.ramengo.orders.repositories.BrothRepository;
import com.redventures.ramengo.orders.repositories.ProteinRepository;
import com.redventures.ramengo.orders.services.impl.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private BrothRepository brothRepository;
    @Mock
    private ProteinRepository proteinRepository;
    @InjectMocks
    private OrderService orderService;
    private Broth broth;
    private Protein protein;
    private Order order;

    @BeforeEach
    void setup(){
        broth = new Broth(1L, "url", "url",
                "salt", "salt", BigDecimal.valueOf(10));
        protein = new Protein(1L, "url", "url",
                "protein", "protein", BigDecimal.valueOf(12));
        order = new Order(broth, protein);
    }

    @Test
    public void testCalculateTotalValue(){
        when(brothRepository.findById(1L)).thenReturn(Optional.of(broth));
        when(proteinRepository.findById(1L)).thenReturn(Optional.of(protein));
        orderService.calculateTotalValue(order);
        assertEquals(BigDecimal.valueOf(22), order.getAmount());
    }

    @Test
    public void testCalculateTotalValueWhenBrothNotFound(){
        when(brothRepository.findById(1L)).thenReturn(Optional.empty());
        Exception brothNotFoundException = assertThrows(BrothNotFoundException.class, () -> {
            orderService.calculateTotalValue(order);
        });
        assertEquals("Broth not found", brothNotFoundException.getMessage());

    }

    @Test
    public void testCalculateTotalValueWhenProteinNotFound(){
        when(brothRepository.findById(1L)).thenReturn(Optional.of(broth));
        when(proteinRepository.findById(1L)).thenReturn(Optional.empty());
        Exception exception = assertThrows(ProteinNotFoundException.class, () -> {
            orderService.calculateTotalValue(order);
        });
        assertEquals("Protein not found", exception.getMessage());
    }
}
