package com.durys.jakub.offerservice.ddd;

import com.durys.jakub.offerservice.events.DomainEvent;
import com.durys.jakub.offerservice.events.EventPublisher;

public abstract class AggregateRoot {

    private final EventPublisher eventPublisher;

    protected AggregateRoot(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    protected void apply(DomainEvent event) {
        eventPublisher.publish(event);
    }
}
