package com.durys.jakub.offerservice.events.outbox;

import org.springframework.stereotype.Component;

@Component
class OutboxService {

    private final EventsRepository eventsRepository;

    OutboxService(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }


}
