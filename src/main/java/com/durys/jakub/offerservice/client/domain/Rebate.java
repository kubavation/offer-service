package com.durys.jakub.offerservice.client.domain;

import com.durys.jakub.offerservice.common.DomainValidationException;

import java.math.BigDecimal;
import java.util.Objects;

public record Rebate(BigDecimal amount) {

    public Rebate {
        if (Objects.isNull(amount) || amount.compareTo(BigDecimal.ZERO) < 1) {
            throw new DomainValidationException("Invalid rebate amount");
        }
    }
}
