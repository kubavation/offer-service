package com.durys.jakub.offerservice.client.domain;

import java.math.BigDecimal;

class DefaultRebatePolicy implements RebatePolicy {

    @Override
    public Rebate calculateRebate(Client.Type clientType) {
        return switch (clientType) {
            case Vip -> new Rebate(BigDecimal.valueOf(20)); //todo
            case Regular -> new Rebate(BigDecimal.valueOf(10));
        };
    }
}
