package com.durys.jakub.offerservice.events.outbox;

import com.durys.jakub.offerservice.events.DomainEvent;
import com.durys.jakub.offerservice.events.EventPublisher;

public class OutboxEventPublisher implements EventPublisher {

    private final EventsRepository eventsRepository;

    public OutboxEventPublisher(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public <T extends DomainEvent> void publish(T event) {
        eventsRepository.save(event);
    }
}
