package com.durys.jakub.offerservice.client.domain.event;

import com.durys.jakub.offerservice.events.DomainEvent;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record RebateGranted(Instant at, UUID rebateId, BigDecimal amount) implements DomainEvent {

    public RebateGranted(UUID rebateId, BigDecimal amount) {
        this(Instant.now(), rebateId, amount);
    }

}
