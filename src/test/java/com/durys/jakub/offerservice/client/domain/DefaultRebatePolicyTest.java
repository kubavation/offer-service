package com.durys.jakub.offerservice.client.domain;

import com.durys.jakub.offerservice.rebate.DefaultRebatePolicy;
import com.durys.jakub.offerservice.rebate.Rebate;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DefaultRebatePolicyTest {

    DefaultRebatePolicy rebatePolicy = new DefaultRebatePolicy();

    @Test
    void shouldCalculateRebateForVipClient() {

        Rebate rebate = rebatePolicy.calculateRebate(Client.Type.Vip);

        assertEquals(BigDecimal.valueOf(20), rebate.amount());
    }

    @Test
    void shouldCalculateRebateForRegularClient() {

        Rebate rebate = rebatePolicy.calculateRebate(Client.Type.Regular);

        assertEquals(BigDecimal.valueOf(10), rebate.amount());
    }

}