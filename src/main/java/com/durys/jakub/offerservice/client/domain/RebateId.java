package com.durys.jakub.offerservice.client.domain;

import com.durys.jakub.offerservice.common.DomainValidationException;

import java.util.Objects;
import java.util.UUID;

public record RebateId(UUID value) {

    public RebateId {
        if (Objects.isNull(value)) {
            throw new DomainValidationException("Invalid rebateId value");
        }
    }
}
