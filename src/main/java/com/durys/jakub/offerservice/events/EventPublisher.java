package com.durys.jakub.offerservice.events;

public interface EventPublisher {
    <T extends DomainEvent> void publish(T event);
}
