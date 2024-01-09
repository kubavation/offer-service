package com.durys.jakub.offerservice.offer.domain;

import com.durys.jakub.offerservice.common.DomainValidationException;

import java.math.BigDecimal;
import java.util.Objects;

public record Price(BigDecimal amount) {

    public Price {
        if (Objects.isNull(amount) || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new DomainValidationException("Invalid price");
        }
    }

}
