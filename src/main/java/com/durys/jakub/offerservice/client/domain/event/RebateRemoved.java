package com.durys.jakub.offerservice.client.domain.event;

import com.durys.jakub.offerservice.client.domain.ClientId;
import com.durys.jakub.offerservice.events.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record RebateRemoved(Instant at, ClientId clientId, UUID rebateId) implements DomainEvent {

    public RebateRemoved(ClientId clientId, UUID rebateId) {
        this(Instant.now(), clientId, rebateId);
    }

}
