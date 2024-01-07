package com.durys.jakub.offerservice.client.domain;

import com.durys.jakub.offerservice.ddd.DomainFactory;
import com.durys.jakub.offerservice.events.EventPublisher;

@DomainFactory
public class ClientFactory {

    private final EventPublisher eventPublisher;

    public ClientFactory(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public Client create(String identifier, Client.Type type) {
        return new Client(new ClientId(identifier), type, eventPublisher);
    }

}
