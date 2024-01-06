package com.durys.jakub.offerservice.events.outbox;

import com.durys.jakub.offerservice.events.DomainEvent;

import java.util.List;

public interface EventsRepository {
    void save(DomainEvent event);
    List<DomainEvent> loadPending();
}
