package com.durys.jakub.offerservice.client.domain;

import com.durys.jakub.offerservice.common.DomainValidationException;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public record Rebate(RebateId id, BigDecimal amount) {

    public Rebate(BigDecimal amount) {
        this(new RebateId(UUID.randomUUID()), amount);
    }

    public Rebate {

        if (Objects.isNull(id)) {
            throw new DomainValidationException("Invalid rebate id");
        }

        if (Objects.isNull(amount) || amount.compareTo(BigDecimal.ZERO) < 1) {
            throw new DomainValidationException("Invalid rebate amount");
        }
    }
}
