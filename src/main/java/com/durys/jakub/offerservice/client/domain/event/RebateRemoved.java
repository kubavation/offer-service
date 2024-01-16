package com.durys.jakub.offerservice.client.domain.event;

import com.durys.jakub.offerservice.client.domain.ClientId;
import com.durys.jakub.offerservice.rebate.RebateId;
import com.durys.jakub.offerservice.events.DomainEvent;

import java.time.Instant;

public record RebateRemoved(Instant at, ClientId clientId, RebateId rebateId) implements DomainEvent {

    public RebateRemoved(ClientId clientId, RebateId rebateId) {
        this(Instant.now(), clientId, rebateId);
    }

}
