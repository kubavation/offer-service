package com.durys.jakub.offerservice.client.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class RebateTest {

    @Test
    void createCreateRebate() {

        BigDecimal validAmount = new BigDecimal("50");

        Rebate rebate = new Rebate(validAmount);

        assertNotNull(rebate);
        assertEquals(validAmount, rebate.amount());
    }

    @Test
    void shouldNotCreateRebateWhenAmountIsZero() {

        BigDecimal zeroAmount = BigDecimal.ZERO;

        assertThrows(RuntimeException.class, () -> new Rebate(zeroAmount));
    }

    @Test
    void shouldNotCreateRebateWhenAmountIsNull() {
        assertThrows(RuntimeException.class, () -> new Rebate(null));
    }

}