package com.durys.jakub.offerservice.events.outbox;

import com.durys.jakub.offerservice.events.DomainEvent;

import java.util.ArrayList;
import java.util.List;

public class InMemoryEventsRepository implements EventsRepository {

    private static final List<DomainEvent> DB = new ArrayList<>();

    @Override
    public void save(DomainEvent event) {
        DB.add(event);
    }

    @Override
    public List<DomainEvent> loadPending() {
        var result = DB.stream().toList();
        DB.clear();
        return result;
    }
}
