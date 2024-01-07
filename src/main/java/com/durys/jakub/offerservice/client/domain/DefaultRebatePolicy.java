package com.durys.jakub.offerservice.client.domain;

import com.durys.jakub.offerservice.ddd.DomainPolicy;

import java.math.BigDecimal;

@DomainPolicy
class DefaultRebatePolicy implements RebatePolicy {

    @Override
    public Rebate calculateRebate(Client.Type clientType) {
        return switch (clientType) {
            case Vip -> new Rebate(BigDecimal.valueOf(20));
            case Regular -> new Rebate(BigDecimal.valueOf(10));
        };
    }
}
