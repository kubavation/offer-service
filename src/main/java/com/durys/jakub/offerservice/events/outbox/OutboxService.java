package com.durys.jakub.offerservice.events.outbox;

import com.durys.jakub.offerservice.events.DomainEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class OutboxService {

    private final EventsRepository eventsRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    OutboxService(EventsRepository eventsRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.eventsRepository = eventsRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }


    @Scheduled(cron = "*/2 * * * * *")
    public void sendEvents() {

        List<DomainEvent> events = eventsRepository.loadPending();

        events
            .forEach(applicationEventPublisher::publishEvent);
    }

}
