package com.durys.jakub.offerservice.offer.domain;

import com.durys.jakub.offerservice.common.DomainValidationException;

import java.util.Objects;
import java.util.UUID;

public record OfferId(UUID value) {

    public OfferId {
        if (Objects.isNull(value)) {
            throw new DomainValidationException("Offer ID value cannot be empty");
        }
    }

}
