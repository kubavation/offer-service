package com.durys.jakub.offerservice.client.domain.event;

import com.durys.jakub.offerservice.client.domain.Client;
import com.durys.jakub.offerservice.client.domain.ClientId;
import com.durys.jakub.offerservice.events.DomainEvent;

import java.time.Instant;

public record ClientStatusChanged(Instant at, ClientId clientId, Client.Type type) implements DomainEvent {

    public ClientStatusChanged(ClientId clientId, Client.Type type) {
        this(Instant.now(), clientId, type);
    }
}
