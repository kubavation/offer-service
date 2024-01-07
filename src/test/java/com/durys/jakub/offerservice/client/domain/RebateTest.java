package com.durys.jakub.offerservice.client.domain;

import com.durys.jakub.offerservice.common.DomainValidationException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class RebateTest {

    @Test
    void createCreateRebate() {

        BigDecimal validAmount = new BigDecimal("50");

        Rebate rebate = new Rebate(UUID.randomUUID(), validAmount);

        assertNotNull(rebate);
        assertEquals(validAmount, rebate.amount());
    }

    @Test
    void shouldNotCreateRebateWhenAmountIsZero() {

        BigDecimal zeroAmount = BigDecimal.ZERO;

        assertThrows(DomainValidationException.class, () -> new Rebate(UUID.randomUUID(), zeroAmount));
    }

    @Test
    void shouldNotCreateRebateWhenAmountIsNull() {
        assertThrows(DomainValidationException.class, () -> new Rebate(UUID.randomUUID(), null));
    }

}