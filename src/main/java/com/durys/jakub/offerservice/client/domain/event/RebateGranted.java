package com.durys.jakub.offerservice.client.domain.event;

import com.durys.jakub.offerservice.client.domain.ClientId;
import com.durys.jakub.offerservice.events.DomainEvent;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record RebateGranted(Instant at, ClientId clientId, UUID rebateId, BigDecimal amount) implements DomainEvent {

    public RebateGranted(ClientId clientId, UUID rebateId, BigDecimal amount) {
        this(Instant.now(), clientId, rebateId, amount);
    }

}
