package com.durys.jakub.offerservice.client.domain;

import java.math.BigDecimal;
import java.util.Objects;

record Rebate(BigDecimal amount) {

    Rebate {
        if (Objects.isNull(amount) || amount.compareTo(BigDecimal.ZERO) < 1) {
            throw new RuntimeException("Invalid rebate amount");
        }
    }
}
